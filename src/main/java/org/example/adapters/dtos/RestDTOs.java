package org.example.adapters.dtos;

public class RestDTOs {
    public record Product(Integer id, String name, Boolean presentationInBox, Integer quantity){}

    public record Item (String name, Integer numberOfBoxes, Integer unitsPerBox, Integer units, Integer total){}
}
