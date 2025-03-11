package com.theskyit.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.theskyit.dto.BusinessContactDTO;
import com.theskyit.dto.HRContactDTO;
import com.theskyit.dto.SkyITContactDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.SkyITContact;
import com.theskyit.repository.SkyITContactRepository;
import com.theskyit.service.SkyITContactService;

@Service
public class SkyITContactServiceImpl implements SkyITContactService {

    private static final Logger logger = LoggerFactory.getLogger(SkyITContactServiceImpl.class);

    @Autowired
    private SkyITContactRepository contactRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public SkyITContact saveContact(SkyITContactDTO contactDTO) {
        logger.info("Saving contact: {}", contactDTO);
        SkyITContact contacts = mapper.map(contactDTO, SkyITContact.class);
        SkyITContact savedContact = contactRepository.save(contacts);
        logger.info("Contact saved successfully: {}", savedContact);
        return savedContact;
    }

    @Override
    public List<SkyITContact> getContactDetails() throws CustomException {
        logger.info("Fetching all contact details");
        List<SkyITContact> contacts = contactRepository.findAll();
        if (contacts.isEmpty()) {
            logger.warn("No contact details found");
            throw new CustomException("No contact details found", HttpStatus.NOT_FOUND);
        }
        logger.info("Successfully fetched {} contacts", contacts.size());
        return contacts;
    }

    @Override
    public HRContactDTO getHRContactDetails() throws CustomException {
        logger.info("Fetching HR contact details");
        List<SkyITContact> contacts = contactRepository.findAll();

        if (contacts.isEmpty()) {
            logger.error("No contact details found for HR");
            throw new CustomException("No contact details found", HttpStatus.NOT_FOUND);
        }

        SkyITContact contact = contacts.get(0);
        HRContactDTO hrContactDTO = new HRContactDTO();
        hrContactDTO.setHrEmail1(contact.getHrEmail1());
        hrContactDTO.setHrEmail2(contact.getHrEmail2());
        hrContactDTO.setHrEmail3(contact.getHrEmail3());

        logger.info("Successfully fetched HR contact details: {}", hrContactDTO);
        return hrContactDTO;
    }

    @Override
    public BusinessContactDTO getBusinessContactDetails() throws CustomException {
        logger.info("Fetching business contact details");
        List<SkyITContact> contacts = contactRepository.findAll();

        if (contacts.isEmpty()) {
            logger.error("No contact details found for business");
            throw new CustomException("No contact details found", HttpStatus.NOT_FOUND);
        }

        SkyITContact contact = contacts.get(0);
        BusinessContactDTO businessContactDTO = new BusinessContactDTO();
        businessContactDTO.setBusinessEmail1(contact.getBusinessEmail1());
        businessContactDTO.setBusinessEmail2(contact.getBusinessEmail2());
        businessContactDTO.setBusinessEmail3(contact.getBusinessEmail3());

        logger.info("Successfully fetched business contact details: {}", businessContactDTO);
        return businessContactDTO;
    }

    @Override
    public SkyITContact deleteContact(String id) throws CustomException {
        logger.info("Deleting contact with id: {}", id);
        Optional<SkyITContact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            SkyITContact contact = contactOptional.get();
            contactRepository.deleteById(id);
            logger.info("Successfully deleted contact: {}", contact);
            return contact;
        } else {
            logger.error("Contact not found with id: {}", id);
            throw new CustomException("Contact not found", HttpStatus.NOT_FOUND);
        }
    }
}