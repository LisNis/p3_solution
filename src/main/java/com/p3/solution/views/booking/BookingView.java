package com.p3.solution.views.booking;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Booking")
@Route("booking")
public class BookingView extends Composite<VerticalLayout> {

    private final BookingForm bookingForm;

    @Autowired
    public BookingView(EmailService emailService) {
        VerticalLayout rootLayout = getContent();
        rootLayout.setWidthFull();
        rootLayout.setPadding(false);

        // Left section (Calendar and time slots)
        VerticalLayout leftContentLayout = new VerticalLayout();
        leftContentLayout.setWidth("50%");
        leftContentLayout.setSpacing(true);

        // Calendar
        H2 calendarTitle = new H2("Vælg dato for reparation:");
        DatePicker datePicker = new DatePicker();
        datePicker.setWidthFull();
        datePicker.setPlaceholder("Vælg dato");

        // Time slots
        Button timeSlot1 = new Button("08.00-10.00");
        Button timeSlot2 = new Button("12.00-14.00");
        timeSlot1.getStyle().set("background-color", "green").set("color", "white");
        timeSlot2.getStyle().set("background-color", "green").set("color", "white");

        leftContentLayout.add(calendarTitle, datePicker, timeSlot1, timeSlot2);

        // Right section with the booking form
        bookingForm = new BookingForm(emailService);
        bookingForm.setWidth("50%");

        // Main content layout
        HorizontalLayout contentLayout = new HorizontalLayout(leftContentLayout, bookingForm);
        contentLayout.setWidthFull();
        rootLayout.add(contentLayout);
    }
}






/*
@PageTitle("Booking")
@Route("booking")
public class BookingView extends Composite<VerticalLayout> {

    public BookingView() {
        VerticalLayout rootLayout = getContent();

        rootLayout.setWidthFull();
        rootLayout.setPadding(false);

        // Main content layout (Booking form and calendar)
        HorizontalLayout contentLayout = new HorizontalLayout();
        contentLayout.setWidthFull();
        contentLayout.setAlignItems(FlexComponent.Alignment.START);

        // Left section (Calendar and time slots)
        VerticalLayout leftContentLayout = new VerticalLayout();
        leftContentLayout.setWidth("50%");
        leftContentLayout.setSpacing(true);

        // Calendar
        H2 calendarTitle = new H2("Vælg dato for reparation:");
        DatePicker datePicker = new DatePicker();
        datePicker.setWidthFull();
        datePicker.setPlaceholder("Vælg dato");

        // Time slots
        Span timeSlotLabel = new Span("Du har valgt en dato, vælg en tid:");
        Button timeSlot1 = new Button("08.00-10.00");
        Button timeSlot2 = new Button("12.00-14.00");

        // Style time slot buttons
        timeSlot1.getStyle().set("background-color", "green").set("color", "white");
        timeSlot2.getStyle().set("background-color", "green").set("color", "white");

        // Add calendar and time slots to the left section
        leftContentLayout.add(calendarTitle, datePicker, timeSlotLabel, timeSlot1, timeSlot2);

        // Right section (Form for user details and bike info)
        VerticalLayout rightContentLayout = new VerticalLayout();
        rightContentLayout.setWidth("50%");
        rightContentLayout.setSpacing(true);

        // Form title
        H2 formTitle = new H2("Dine oplysninger:");

        // User Details Form
        FormLayout formLayout = new FormLayout();
        TextField firstName = new TextField("Fornavn*");
        TextField lastName = new TextField("Efternavn*");
        TextField phoneNumber = new TextField("Mobil nummer*");
        EmailField email = new EmailField("Email*");

        // Add form fields to form layout
        formLayout.add(firstName, lastName, phoneNumber, email);

        // Bike Information section
        Span bikeInfoTitle = new Span("Cykel informationer:");
        bikeInfoTitle.getElement().getStyle().set("font-weight", "bold");
        TextArea commentField = new TextArea("Kommentarfelt*");
        commentField.setPlaceholder("Skriv nærmere beskrivelse");

        // Submit button
        Button submitButton = new Button("Bestil");
        submitButton.getStyle().set("background-color", "black").set("color", "white");

        // Add form elements to the right section
        rightContentLayout.add(formTitle, formLayout, bikeInfoTitle, commentField, submitButton);

        // Combine left and right content sections in the main content layout
        contentLayout.add(leftContentLayout, rightContentLayout);

        // Add top navigation bar and main content layout to the root layout
        rootLayout.add(contentLayout);
    }
}
         */