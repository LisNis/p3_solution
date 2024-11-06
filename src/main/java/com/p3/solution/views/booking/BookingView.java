package com.p3.solution.views.booking;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.Composite;

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


/*
        // Top navigation bar with icon on the left and links + button on the right
        HorizontalLayout topNavBar = new HorizontalLayout();
        topNavBar.setWidthFull();
        topNavBar.setAlignItems(FlexComponent.Alignment.CENTER);

        // Left section (icon)
        HorizontalLayout leftIconLayout = new HorizontalLayout();
        Image bikeIcon = new Image("icons/bike-icon.svg", "Bike Icon"); // Load custom bike icon
        bikeIcon.setWidth("24px");
        bikeIcon.setHeight("24px");
        leftIconLayout.add(bikeIcon);

        // Right section (links and button)
        HorizontalLayout rightNavLayout = new HorizontalLayout();
        Anchor link = new Anchor("#", "Forside");
        Anchor link2 = new Anchor("#", "Kontakt");
        link.getStyle().set("color", "green");
        link2.getStyle().set("color", "green");
        Button buttonPrimary = new Button("Book tid");
        buttonPrimary.getStyle().set("background-color", "green").set("color", "white");
        buttonPrimary.setWidth("min-content");

        // Add links and button to the right layout
        rightNavLayout.add(link, link2, buttonPrimary);
        rightNavLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Combine left and right parts in the top navigation bar
        topNavBar.add(leftIconLayout, rightNavLayout);
        topNavBar.expand(leftIconLayout); // Push links + button to the far right


         */