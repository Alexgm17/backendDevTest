package org.alejandrogm.service.dto.output;

import java.math.BigDecimal;

public class ProductDetailODTO {
    private String id;
    private String name;
    private BigDecimal price;
    private Boolean availability;

    public ProductDetailODTO (String id, String name, BigDecimal price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public ProductDetailODTO () {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailability () {
        return availability;
    }

    public void setAvailability (Boolean availability) {
        this.availability = availability;
    }
}
