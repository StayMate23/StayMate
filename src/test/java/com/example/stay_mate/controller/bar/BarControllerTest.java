package com.example.stay_mate.controller.bar;

import com.example.stay_mate.controller.bar.BarController;
import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.service.bar.BarService;
import com.example.stay_mate.service.menubook.MenuBookService;
import com.example.stay_mate.service.partner.PartnerService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BarControllerTest {

    @Test
    void testGetAllBars() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        Model model = new BindingAwareModelMap();

        List<Bar> expectedBars = Arrays.asList(new Bar(), new Bar(), new Bar());
        when(barService.getAllBar()).thenReturn(expectedBars);

        // Act
        String viewName = barController.getAllBars(model);

        // Assert
        assertEquals("bar-list", viewName);
        assertEquals(expectedBars, model.getAttribute("all_bars"));
        verify(barService, times(1)).getAllBar();
    }

    @Test
    void testGetCurrentBar() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        Model model = new BindingAwareModelMap();
        int barId = 1;

        Bar expectedBar = new Bar();
        when(barService.getBarById(barId)).thenReturn(expectedBar);

        // Act
        String viewName = barController.getCurrentBar(model, barId);

        // Assert
        assertEquals("bar", viewName);
        assertEquals(expectedBar, model.getAttribute("bar"));
        verify(menuBookService, times(1)).getMenuBookByBar(expectedBar);
        verify(barService, times(1)).getBarById(barId);
    }

    @Test
    void testAddBar() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        Model model = new BindingAwareModelMap();
        int partnerId = 123;

        Bar newBar = new Bar();
        when(partnerService.getPartnerById(partnerId)).thenReturn(new Bar().getPartner());

        // Act
        String viewName = barController.addBar(model, partnerId);

        // Assert
        assertEquals("new-bar-form", viewName);
        assertEquals(partnerId, model.getAttribute("partnerId"));
        assertEquals(new Bar(), model.getAttribute("new_bar"));
        verify(partnerService, times(1)).getPartnerById(partnerId);
    }

    @Test
    void testAddBarPost() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        int partnerId = 123;

        Bar newBar = new Bar();
        when(partnerService.getPartnerById(partnerId)).thenReturn(new Bar().getPartner());

        // Act
        String viewName = barController.addBar(newBar, partnerId);

        // Assert
        assertEquals("redirect:/partner/current", viewName);
        verify(barService, times(1)).saveBar(newBar);
    }

    @Test
    void testUpdateBar() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        Model model = new BindingAwareModelMap();
        int barId = 1;

        Bar updatedBar = new Bar();
        when(barService.getBarById(barId)).thenReturn(updatedBar);

        // Act
        String viewName = barController.updateBar(barId, model);

        // Assert
        assertEquals("bar-update", viewName);
        assertEquals(updatedBar, model.getAttribute("updated_bar"));
        verify(barService, times(1)).getBarById(barId);
    }

    @Test
    void testUpdateBarPost() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        int barId = 1;

        Bar updatedBar = new Bar();

        // Act
        String viewName = barController.updateBar(barId, updatedBar);

        // Assert
        assertEquals("redirect:/partner/current", viewName);
        verify(barService, times(1)).saveBar(updatedBar);
    }

    @Test
    void testDeleteBar() {
        // Arrange
        BarService barService = mock(BarService.class);
        MenuBookService menuBookService = mock(MenuBookService.class);
        PartnerService partnerService = mock(PartnerService.class);
        BarController barController = new BarController(barService, menuBookService, partnerService);
        int barId = 1;

        Bar barToDelete = new Bar();
        when(barService.getBarById(barId)).thenReturn(barToDelete);

        // Act
        String viewName = barController.deleteBar(barId);

        // Assert
        assertEquals("redirect:/partner/current", viewName);
        verify(menuBookService, times(1)).deleteMenuBookByBar(barToDelete);
        verify(barService, times(1)).deleteBarById(barId);
    }
}

