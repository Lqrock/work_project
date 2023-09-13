package com.temporary.workforce.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    private int id;

    private int beds;

    private List<FurnitureDTO> furniture;
}
