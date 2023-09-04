package com.sistemalanchonete.sistemalanchonete.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends Entity{
    private Double valorUnitario;
    private Double quantidade;
    private List<ItemsMenu> itens = new ArrayList<>();

}
