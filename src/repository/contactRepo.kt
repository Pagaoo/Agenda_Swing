package repository

import entity.contactEntity

class contactRepo {

    companion object {
        private val contactList = mutableListOf<contactEntity>()

        fun saveContact(contact: contactEntity) {
            contactList.add(contact)
        }

        fun deleteContact(contact: contactEntity) {

        }

        fun getContactList(): MutableList<contactEntity> {
            return contactList
        }
    }
}