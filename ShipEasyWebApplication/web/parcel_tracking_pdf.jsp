<%@page import="ac.za.tut.driver.Driver"%>
<%@page import="ac.za.tut.status.Status"%>
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
    Status status = (Status) session.getAttribute("status");
    Shipment shipment = (Shipment) session.getAttribute("shipment");
    Driver driverAssingned = (Driver) session.getAttribute("driverAssingned");

    if (shipment == null) {
        out.println("No shipment data available.");
        return;
    }

    // Set response content type
    response.setContentType("application/pdf");

    // Set response header for PDF attachment
    response.setHeader("Content-Disposition", "attachment; filename=\"shipment_status.pdf\"");

    // Create PDF document
    Document document = new Document();
    try {
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
        document.add(new Paragraph("Thank you for choosing our services. Below you will find the Tracking Status of  your Parcel.", boldFont));
        document.add(new Paragraph("\n")); // Add some space

        // Add shipment details to the document
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Pickup Point: ", boldFont));
        document.add(new Paragraph(shipment.getPickLocation() != null ? shipment.getPickLocation() : "N/A"));
        document.add(new Paragraph("Type: ", boldFont));
        document.add(new Paragraph(shipment.getProduct().getType() != null ? shipment.getProduct().getType() : "N/A"));
        document.add(new Paragraph("Weight: ", boldFont));
        document.add(new Paragraph(String.valueOf(shipment.getProduct().getWeight())));
        document.add(new Paragraph("Destination: ", boldFont));
        document.add(new Paragraph(shipment.getDestination() != null ? shipment.getDestination() : "N/A"));
        document.add(new Paragraph("Requested On: ", boldFont));
        document.add(new Paragraph(new SimpleDateFormat("yyyy-MM-dd").format(shipment.getCreationDate())));
        document.add(new Paragraph("Price: ", boldFont));
        document.add(new Paragraph(String.valueOf(shipment.getProduct().getPrice())));
        document.add(new Paragraph("Tracking Key: ", boldFont));
        document.add(new Paragraph(shipment.getProduct().getTrackingCode() != null ? shipment.getProduct().getTrackingCode() : "N/A"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Shipment Status", boldFont));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Status: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getStatus() != null ? shipment.getStatus().getStatus() : "N/A"));
        document.add(new Paragraph("Transportation Mode: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getTransportationMode() != null ? shipment.getStatus().getTransportationMode() : "N/A"));
        document.add(new Paragraph("Shipping Method: ", boldFont));
        document.add(new Paragraph(shipment.getStatus().getShippingMethod() != null ? shipment.getStatus().getShippingMethod() : "N/A"));

        // Check if delivery date is not null before adding
        if (shipment.getStatus().getDeliveryDate() != null) {
            document.add(new Paragraph("Estimated Delivery Date: ", boldFont));
            document.add(new Paragraph(new SimpleDateFormat("yyyy-MM-dd").format(shipment.getStatus().getDeliveryDate())));
        }

        document.add(new Paragraph("\n"));
        
        Paragraph driverTitle = new Paragraph("Assigned Driver", boldFont);
        title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        document.add(driverTitle);
        
        document.add(new Paragraph("\n"));
        
        document.add(new Paragraph("Full Names:", boldFont));
        document.add(new Paragraph(driverAssingned.getFullNames() != null ? driverAssingned.getFullNames() : "N/A"));
        document.add(new Paragraph("Surname:", boldFont));
        document.add(new Paragraph(driverAssingned.getSurname() != null ? driverAssingned.getSurname() : "N/A"));
        document.add(new Paragraph("Email Address: ", boldFont));
        document.add(new Paragraph(driverAssingned.getEmail() != null ? driverAssingned.getEmail() : "N/A"));
        document.add(new Paragraph("Contact Number:", boldFont));
        document.add(new Paragraph(driverAssingned.getCellNumber() != null ? driverAssingned.getCellNumber() : "N/A"));

        document.add(new Paragraph("\n"));
        
        // Add contact information
        document.add(new Paragraph("For any inquiries, please contact us at support@shipeasy.com or info@shipeasy.com", boldFont));

    } catch (Exception e) {
        out.println("Error generating PDF: " + e.getMessage());
        e.printStackTrace();
    } finally {
        document.close();
    }
%>
