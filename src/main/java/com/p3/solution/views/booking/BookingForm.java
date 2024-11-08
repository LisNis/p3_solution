package com.p3.solution.views.booking;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.notification.Notification;

public class BookingForm extends VerticalLayout {

    private final TextField firstName;
    private final TextField lastName;
    private final TextField phoneNumber;
    private final EmailField email;
    private final TextArea commentField;

    public BookingForm(EmailService emailService) {
        H2 formTitle = new H2("Dine oplysninger:");

        // Form Layout for user details
        FormLayout formLayout = new FormLayout();
        firstName = new TextField("Fornavn*");
        lastName = new TextField("Efternavn*");
        phoneNumber = new TextField("Mobil nummer*");
        email = new EmailField("Email*");
        formLayout.add(firstName, lastName, phoneNumber, email);

        // Bike Information section
        Span bikeInfoTitle = new Span("Cykel informationer:");
        bikeInfoTitle.getElement().getStyle().set("font-weight", "bold");
        commentField = new TextArea("Kommentarfelt*");
        commentField.setPlaceholder("Skriv nærmere beskrivelse");

        // Submit Button
        Button submitButton = new Button("Bestil");
        submitButton.getStyle().set("background-color", "black").set("color", "white");

        // Add button click listener to send an email
        submitButton.addClickListener(event -> {
            System.out.println("Email sent");
            /*
            boolean emailSent = emailService.sendBookingConfirmation(
                    email.getValue(),
                    "Booking Confirmation",
                    "Thank you for booking with us! Your appointment is confirmed."
            );
            if (emailSent) {
                Notification.show("Confirmation email sent!", 3000, Notification.Position.MIDDLE);
            } else {
                Notification.show("Failed to send email.", 3000, Notification.Position.MIDDLE);
            }

             */
        });

        // Add components to the layout
        add(formTitle, formLayout, bikeInfoTitle, commentField, submitButton);
    }
}
