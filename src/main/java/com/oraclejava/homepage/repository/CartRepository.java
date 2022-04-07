package com.oraclejava.homepage.repository;

import com.oraclejava.homepage.dto.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
@Data
public class CartRepository {
    @Autowired
	private Cart cart;
}
