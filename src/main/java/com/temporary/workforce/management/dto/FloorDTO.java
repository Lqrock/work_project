package com.temporary.workforce.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class FloorDTO {

    private int id;

    private List<RoomDTO> rooms;
}
