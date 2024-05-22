<%@page import="com.itextpdf.text.Font"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page contentType="application/pdf; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.servlet.ServletOutputStream"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<%
    // Retrieve shipments from session
    List<Shipment> shipments = (List<Shipment>) session.getAttribute("shipments");

    // Set response content type
    response.setContentType("application/pdf");

    // Set response header for PDF attachment
    response.setHeader("Content-Disposition", "attachment; filename=\"shipment_details.pdf\"");

    // Create PDF document
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
    document.open();

    // Define bold font
    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

    // Add title to the PDF
    Paragraph title = new Paragraph("Shipment Details", boldFont);
    title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
    document.add(title);
    document.add(new Paragraph("\n")); // Add some space

    // Add introductory information
    Paragraph intro = new Paragraph("Dear Customer,", boldFont);
    intro.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
    document.add(intro);
    document.add(new Paragraph("\n")); // Add some space
    document.add(new Paragraph("Thank you for choosing our services. Below you will find the details of your shipments.", boldFont));
    document.add(new Paragraph("\n")); // Add some space

    // Add shipments to the document
    for (int i = 0; i < shipments.size(); i++) {
    
        Shipment shipment = shipments.get(i);
        
        document.add(new Paragraph("Shipment "+(i+1),boldFont));
        
        document.add(new Paragraph("\n")); 
    
        document.add(new Paragraph("Pickup Point: ", boldFont));
        document.add(new Paragraph(shipment.getPickLocation()));
        document.add(new Paragraph("Type: ", boldFont));
        document.add(new Paragraph(shipment.getProduct().getType()));
        document.add(new Paragraph("Weight: ", boldFont));
        document.add(new Paragraph(String.valueOf(shipment.getProduct().getWeight())));
        document.add(new Paragraph("Destination: ", boldFont));
        document.add(new Paragraph(shipment.getDestination()));
        document.add(new Paragraph("Requested On: ", boldFont));
        document.add(new Paragraph(new SimpleDateFormat("yyyy-MM-dd").format(shipment.getCreationDate())));
        document.add(new Paragraph("Price: ", boldFont));
        document.add(new Paragraph(String.valueOf(shipment.getProduct().getPrice())));
        document.add(new Paragraph("Tracking Key: ", boldFont));
        document.add(new Paragraph(shipment.getProduct().getTrackingCode()));
        document.add(new Paragraph("\n")); 
        document.add(new Paragraph("Shipment Status", boldFont));
        document.add(new Paragraph("\n")); 
        document.add(new Paragraph("Status: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getStatus()));
        document.add(new Paragraph("Transportation Mode: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getTransportationMode()));
        document.add(new Paragraph("Shipping Method: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getShippingMethod()));
        
        // Check if delivery date is not null before adding
        if (shipment.getStatus().getDeliveryDate() != null) {
            document.add(new Paragraph("Estimated Delivery Date: ", boldFont));
            document.add(new Paragraph(new SimpleDateFormat("yyyy-MM-dd").format(shipment.getStatus().getDeliveryDate())));
        }
        
        document.add(new Paragraph("\n")); 
    }
    
    // Add contact information
    document.add(new Paragraph("For any inquiries, please contact us at support@shipeasy.com or info@shipeasy.com", boldFont));

    // Close document
    document.close();
%>
