<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Element"%>
<<<<<<< HEAD
<%@page import="com.itextpdf.text.Font"%>
<%@page import="com.itextpdf.text.FontFactory"%>
<%@page import="com.itextpdf.text.BaseColor"%>
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="application/pdf; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<%
    Shipment shipment = (Shipment) session.getAttribute("shipment");
    if (shipment == null) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Shipment data is missing.");
        return;
    }

    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment; filename=\"shipment_delivery_report.pdf\"");

    Document document = new Document();
    try {
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

<<<<<<< HEAD
        // Define fonts
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);

        // Add title
        Paragraph title = new Paragraph("Shipment Delivery Report", titleFont);
=======
        Paragraph title = new Paragraph("Shipment Delivery Report");
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("\n"));
<<<<<<< HEAD

        // Add recipient details section
        Paragraph recipientSection = new Paragraph("Recipient Details", sectionFont);
        document.add(recipientSection);
        document.add(new Paragraph("\n"));
        
        document.add(new Paragraph("Shipment ID (Tracking Code): " + shipment.getProduct().getTrackingCode(), normalFont));
        document.add(new Paragraph("Recipient: " + shipment.getUser().getName() + " " + shipment.getUser().getSurname(), normalFont));
        document.add(new Paragraph("Email: " + shipment.getUser().getEmail(), normalFont));
        document.add(new Paragraph("Cell phone number: " + shipment.getUser().getPhoneNumber(), normalFont));

        document.add(new Paragraph("\n"));

        // Add shipment details section
        Paragraph shipmentSection = new Paragraph("Shipment Details", sectionFont);
        document.add(shipmentSection);
        document.add(new Paragraph("\n"));
        
        document.add(new Paragraph("Pick-Up Location: " + shipment.getPickLocation(), normalFont));
        document.add(new Paragraph("Destination: " + shipment.getDestination(), normalFont));
        document.add(new Paragraph("Weight (kg): " + shipment.getProduct().getWeight(), normalFont));
        document.add(new Paragraph("Type: " + shipment.getProduct().getType(), normalFont));

        document.add(new Paragraph("\n"));

        // Add delivery date
        document.add(new Paragraph("Delivery Date: " + new SimpleDateFormat("yyyy-MM-dd").format(shipment.getStatus().getDeliveryDate()), normalFont));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Recipient's Signature: __________________________", normalFont));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Driver Signature: __________________________", normalFont));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("For any inquiries, please contact us at support@shipeasy.com or info@shipeasy.com", infoFont));
=======
        document.add(new Paragraph("Recipient Details"));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Shipment ID (Tracking Code): " + shipment.getProduct().getTrackingCode()));
        document.add(new Paragraph("Recipient: " + shipment.getUser().getName()+ " " + shipment.getUser().getSurname()));
        document.add(new Paragraph("Email: " + shipment.getUser().getEmail()));
        document.add(new Paragraph("Cell phone number: " + shipment.getUser().getPhoneNumber()));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Shipment Details"));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Pick-Up Location: " + shipment.getPickLocation()));
        document.add(new Paragraph("Destination: " + shipment.getDestination()));
        document.add(new Paragraph("Weight (kg): " + shipment.getProduct().getWeight()));
        document.add(new Paragraph("Type: " + shipment.getProduct().getType()));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Delivery Date : "+ new SimpleDateFormat("yyyy-MM-dd").format(shipment.getStatus().getDeliveryDate())));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Recipient's Signature: __________________________"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Driver Signature: __________________________"));

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("info@shipeasy.com"));
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

    } catch (Exception e) {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF.");
        e.printStackTrace();
    } finally {
        document.close();
    }
%>
