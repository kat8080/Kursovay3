package com.example.kursovay3.dto;

import com.example.kursovay3.model.Color;
import com.example.kursovay3.model.Size;
import com.example.kursovay3.model.Sock;

public class SockRequest {
    private Color color;
    private Size size;
    public int cottonPart;
    public int quantity;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
