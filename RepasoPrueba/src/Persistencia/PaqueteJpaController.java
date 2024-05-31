/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Clases.Paquete;
import Clases.exceptions.NonexistentEntityException;
import Clases.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Usuario
 */
public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PaqueteJpaController() {
        emf = Persistence.createEntityManagerFactory("RepasoPrueba_PU");
    }
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paquete);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaquete(paquete.getIdPaquete()) != null) {
                throw new PreexistingEntityException("Paquete " + paquete + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            paquete = em.merge(paquete);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getIdPaquete();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getIdPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
