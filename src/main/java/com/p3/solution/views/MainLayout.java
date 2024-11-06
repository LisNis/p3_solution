package com.p3.solution.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxSizing;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    public MainLayout() {
        // Create a container layout for the headers
        VerticalLayout headerContainer = new VerticalLayout();
        headerContainer.setWidthFull();
        headerContainer.setPadding(false);
        headerContainer.setSpacing(false); // Adjust spacing if needed

        headerContainer.add(createHeaderContent(), createSecondHeaderContent());

        // Add container to nav
        addToNavbar(headerContainer);
    }

    private Component createHeaderContent() {
            Header header = new Header();
            header.addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, Width.FULL);

            header.getStyle()
                    .set("display", "flex")
                    .set("align-items", "center")
                    .set("justify-content", "center") // Center horizontally
                    .set("text-align", "center");

            Div layout = new Div();
            layout.addClassNames(Display.FLEX, AlignItems.CENTER, Padding.Horizontal.LARGE);

            H1 appName = new H1("Cykelværksted");
            appName.addClassNames(Margin.Vertical.MEDIUM, Margin.End.AUTO, FontSize.LARGE);
            layout.add(appName);

            Nav nav = new Nav();
            nav.addClassNames(Display.FLEX, Overflow.AUTO, Padding.Horizontal.MEDIUM, Padding.Vertical.XSMALL);

            // links in list
            UnorderedList list = new UnorderedList();
            list.addClassNames(Display.FLEX, Gap.SMALL, ListStyleType.NONE, Margin.NONE, Padding.NONE);
            nav.add(list);

            header.add(layout, nav);
            return header;
        }

        private Component createSecondHeaderContent() {
            Header secondHeader = new Header();
            secondHeader.addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.ROW, Width.FULL, Padding.Horizontal.LARGE);
            secondHeader.getStyle().set("background-color", "white");//.set("margin-top", "20px");

            // Icon on the far left
            Image bikeIcon = new Image("../../../resources/bicycle.png", "Bike Icon"); // Need to change (Freep!k)
            bikeIcon.setWidth("24px");
            bikeIcon.setHeight("24px");

            // links and button
            HorizontalLayout linksAndButtonLayout = new HorizontalLayout();
            linksAndButtonLayout.setWidthFull();
            linksAndButtonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END); // Push content to the right
            linksAndButtonLayout.setAlignItems(FlexComponent.Alignment.CENTER);

            // Links
            Anchor link1 = new Anchor("#", "Forside");
            Anchor link2 = new Anchor("#", "Kontakt");
            link1.getStyle().set("color", "green").set("cursor", "pointer");
            link2.getStyle().set("color", "green").set("cursor", "pointer");

            // Button
            Button bookingButton = new Button("Book tid");
            bookingButton.getStyle().set("background-color", "green").set("color", "white").set("cursor", "pointer");
            bookingButton.addClickListener(event -> UI.getCurrent().navigate("booking")); // Navigate to /booking on click

            // Add links and button to the layout
            linksAndButtonLayout.add(link1, link2, bookingButton);

            // Add icon to the second header, and the links and button layout
            secondHeader.add(bikeIcon, linksAndButtonLayout);

            return secondHeader;
        }
    }


