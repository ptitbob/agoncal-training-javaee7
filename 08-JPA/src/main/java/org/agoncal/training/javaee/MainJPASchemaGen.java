package org.agoncal.training.javaee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         Training - Beginning with The Java EE 7 Platform
 *         http://www.antoniogoncalves.org
 *         --
 */
@Vetoed
public class MainJPASchemaGen {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static final Logger logger = LogManager.getLogger(MainJPASchemaGen.class);

    private static String PERSISTENCE_UNIT_NAME = "trainingPU";

    // ======================================
    // =          Business methods          =
    // ======================================

    public static void main(String[] args) {

        Persistence.generateSchema(PERSISTENCE_UNIT_NAME, null);

        logger.info("DDL have been generated");
    }
}


