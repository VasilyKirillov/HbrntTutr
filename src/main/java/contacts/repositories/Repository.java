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

    public void save(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public Collection<T> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }
}
