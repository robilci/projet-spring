/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.service;

import spring.core.entity.User;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author robin
 */
public interface EmailService {
    public void EnvoieMotdePasse(User user,  String motdepasse)throws ParseException;
}
