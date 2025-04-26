package vaadin.sample.module.backend.employee;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeEntityListener {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeEntityListener.class);

    @PostLoad
    private void postLoad(EmployeeEntity entity) {
        logger.trace("postLoad: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PreUpdate
    private void preUpdate(EmployeeEntity entity) {
        logger.trace("preUpdate: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PostUpdate
    private void postUpdate(EmployeeEntity entity) {
        logger.trace("postUpdate: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PrePersist
    private void prePersist(EmployeeEntity entity) {
        logger.trace("prePersist: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PostPersist
    private void postPersist(EmployeeEntity entity) {
        logger.trace("postPersist: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PreRemove
    private void preRemove(EmployeeEntity entity) {
        logger.trace("preRemove: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }

    @PostRemove
    private void postRemove(EmployeeEntity entity) {
        logger.trace("postRemove: '{}' entity: '{}'", entity.getClass().getName(), entity);
    }
}
