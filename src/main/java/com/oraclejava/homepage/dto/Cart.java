package com.oraclejava.homepage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Cart {
    private List<Integer> items;	// 품목
	private int totalQty;		// 수량

    public Cart() {
		this.items = new ArrayList<>();
		this.totalQty =0;
	}

	public void addItem(Integer id) {
		items.add(id);
		totalQty++;
	}
}
