package br.com.aquavida.controller.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {

    void executar(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException;

}