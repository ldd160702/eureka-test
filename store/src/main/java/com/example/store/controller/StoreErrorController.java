package com.example.store.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class StoreErrorController implements ErrorController {

        private static final String PATH = "/error";


        public String getErrorPath() {
            return PATH;
        }

        @RequestMapping(value = PATH)
        public String error() {
            return "error";
        }
}
