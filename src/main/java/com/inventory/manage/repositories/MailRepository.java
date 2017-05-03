/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Mail;

/**
 * @author mshawahn
 *
 */
public interface MailRepository extends JpaRepository<Mail, Long> {

}
