/**
 * 
 */
package com.inventory.manage.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Mail;
import com.inventory.manage.repositories.MailRepository;

/**
 * @author Rami
 *
 */
@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {

	@Autowired
	private MailRepository mailRepository;

	/**
	 * Send an email
	 */
	@Override
	public boolean sendEmail(Mail mail) {
		// TODO To be implemented
		return false;
	}
}
