package com.example.stay_mate.controller.reservation;

import com.example.stay_mate.model.reservation.Reservation;
import com.example.stay_mate.model.user.User;
import com.example.stay_mate.service.ReservationService;
import com.example.stay_mate.service.bar.BarService;
import com.example.stay_mate.service.hotel.HotelBarService;
import com.example.stay_mate.service.hotel.HotelRestaurantService;
import com.example.stay_mate.service.hotel.HotelService;
import com.example.stay_mate.service.restaurant.RestaurantService;
import com.example.stay_mate.service.room.RoomService;
import com.example.stay_mate.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {

    @Mock
    private ReservationService reservationService;

    @Mock
    private UserService userService;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private BarService barService;

    @Mock
    private HotelService hotelService;

    @Mock
    private HotelRestaurantService hotelRestaurantService;

    @Mock
    private HotelBarService hotelBarService;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    User mockUser = new User(
            22,
            "Mock",
            "Mock",
            "Mock",
            "22",
            "mock@mail.com",
            "password",
            "22",
            LocalDate.of(2022, 2, 22),
            "static/logo.png"
    );


    @Test
    public void testGetAllRoom() {
        Integer userId = 1;

        when(roomService.getAllRooms()).thenReturn(Collections.emptyList());
        when(userService.getUserById(userId)).thenReturn(mockUser);

        String viewName = reservationController.getAllRoom(model, userId);

        assertEquals(null, viewName);

        verify(model, times(1)).addAttribute(eq("room"), any(List.class));
        verify(model, times(1)).addAttribute(eq("userId"), any());
    }

    @Test
    public void testGetRoom() {
        Integer userId = 1;

        when(roomService.getAllRooms()).thenReturn(Collections.emptyList());
        when(restaurantService.getAllRestaurants()).thenReturn(Collections.emptyList());
        when(barService.getAllBar()).thenReturn(Collections.emptyList());
        when(hotelRestaurantService.getAllHotelRestaurants()).thenReturn(Collections.emptyList());
        when(hotelBarService.getAllHotelBars()).thenReturn(Collections.emptyList());
        when(userService.getUserById(userId)).thenReturn(mockUser);

        String viewName = reservationController.getRoom(model, userId);

        assertEquals("offer", viewName);

        verify(model, times(1)).addAttribute(eq("room"), any(List.class));
        verify(model, times(1)).addAttribute(eq("restaurant"), any(List.class));
        verify(model, times(1)).addAttribute(eq("bar"), any(List.class));
        verify(model, times(1)).addAttribute(eq("hotelRestaurant"), any(List.class));
        verify(model, times(1)).addAttribute(eq("hotelBar"), any(List.class));
        verify(model, times(1)).addAttribute(eq("userId"), any());
    }

    // Additional tests for other controller methods can be added similarly
}


