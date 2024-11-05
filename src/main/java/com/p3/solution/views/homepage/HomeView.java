package com.p3.solution.views.homepage;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Image;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/pencil-ruler-solid.svg")
public class HomeView extends Composite<VerticalLayout> {

    public HomeView() {
        // Main layout that contains left and right sections
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();
        mainLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Left section with icon
        HorizontalLayout leftLayout = new HorizontalLayout();
        Image bikeIcon = new Image("icons/bike-icon.svg", "Bike Icon"); // Load custom bike icon
        bikeIcon.setWidth("24px");
        bikeIcon.setHeight("24px");
        leftLayout.add(bikeIcon); // Add the icon to the left layout

        // Right section with links and button
        HorizontalLayout rightLayout = new HorizontalLayout();
        Anchor link = new Anchor("#", "Forside");
        Anchor link2 = new Anchor("#", "Kontakt");
        link.getStyle().set("color", "green");
        link2.getStyle().set("color", "green");
        Button buttonPrimary = new Button("Book tid");

        // Style the button
        buttonPrimary.getStyle().set("background-color", "green");
        buttonPrimary.getStyle().set("color", "white");
        buttonPrimary.setWidth("min-content");

        // Add components to the right layout
        rightLayout.add(link, link2, buttonPrimary);
        rightLayout.setAlignItems(FlexComponent.Alignment.CENTER); // Center links and button

        // Add both left and right layouts to the main layout
        mainLayout.add(leftLayout, rightLayout);
        mainLayout.expand(leftLayout);

        // Main content setup
        H1 h1 = new H1("Dit professionelle cykelværksted");
        h1.setWidth("max-content");

        Paragraph textMedium = new Paragraph("Jeg er her for at hjælpe med alle typer cykler, så du hurtigt kan komme på vejen igen!");
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");

        // Secondary layout for additional buttons
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        layoutRow2.setWidthFull();
        layoutRow2.setAlignItems(FlexComponent.Alignment.CENTER);

        Button buttonPrimary2 = new Button("Book tid");
        buttonPrimary2.getStyle().set("background-color", "green");
        buttonPrimary2.getStyle().set("color", "white");
        buttonPrimary2.setWidth("min-content");

        buttonPrimary2.addClickListener(event -> {
            UI.getCurrent().navigate("booking"); // This will navigate to the "/booking" route
        });

        Button buttonSecondary = new Button("Kontakt os");
        buttonSecondary.getStyle().set("color", "green");
        buttonSecondary.setWidth("min-content");

        // Adding elements to the main layout
        getContent().add(mainLayout, h1, textMedium, layoutRow2);
        layoutRow2.add(buttonPrimary2, buttonSecondary);
    }
}
