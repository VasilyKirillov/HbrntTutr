/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts.repositories;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Repository<T> {

    private final EntityManager em = Persistence.createEntityManagerFactory("training")
            .createEntityManager();

    private Class<T> entityClass;

    public Repository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T find(long id) {
        return em.find(entityClass, id);
    }

    public T save(T entity) {
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Collection<T> findAll() {
        em.clear();
        return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }
}
