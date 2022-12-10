package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceMockTest {

    @Mock
    private CarStorage carStorage;
    @Mock
    private RentalStorage rentalStorage;
    @Mock Rental rental;
    @Mock Car car;
    @InjectMocks
    private CarService carService;

    @Test
    void shouldNotRentCarThatDoesntExist() throws Exception {
        //given
        Car testCar = new Car("renault", "clio", "123", CarType.BLAZINGLY_FAST);
        when(carStorage.findByVin(any())).thenReturn(testCar);

        //when
        RentalInfo result = carService.rentCar(new User("123"), "vin", LocalDate.now(), LocalDate.now().plusDays(10));

        //then
        assertEquals(result.getPrice(), 4000);
    }
}
