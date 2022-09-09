package com.example.Airline_API.services;

import com.example.Airline_API.models.Flight;
import com.example.Airline_API.models.Passenger;
import com.example.Airline_API.repositories.FlightRepository;
import com.example.Airline_API.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(long id){
        return flightRepository.findById(id).get();
    }

    public Flight saveFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public Flight addPassengerToFlight(long flightId, long passengerId){
        Passenger passenger = passengerRepository.findById(passengerId).get();
        Flight flight = flightRepository.findById(flightId).get();
        flight.addPassengers(passenger);
        flightRepository.save(flight);
        return flight;
    }

    public void cancelFlightById(long id){
        flightRepository.deleteById(id);
    }

}
