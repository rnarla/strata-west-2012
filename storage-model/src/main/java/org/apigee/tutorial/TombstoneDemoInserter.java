package org.apigee.tutorial;

import me.prettyprint.cassandra.model.BasicColumnFamilyDefinition;
import me.prettyprint.cassandra.service.ThriftCfDef;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import me.prettyprint.hector.api.ddl.ComparatorType;
import org.apigee.tutorial.common.SchemaUtils;
import org.apigee.tutorial.common.TutorialBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a few static rows of data modelling users. The interesting part takes place in
 * TombstoneDemoQuery.
 *
 * #CQL
 * To do a batch insert via CQL, use the following syntax:
 *
 * #NOTE
 * Inserting timeseries data is one of the places where CQL gets a bit cumbersome.
 *
 * @author zznate
 */
public class TombstoneDemoInserter extends TutorialBase {

  private Logger log = LoggerFactory.getLogger(TombstoneDemoInserter.class);

  public static final String CF_TOMBSTONE_DEMO = "TombstoneDemo";

  protected void maybeCreateSchema() {
    // TombstoneDemo
        // TODO timeseries CF creation 'TimeseriesSingleRow'
    BasicColumnFamilyDefinition columnFamilyDefinition = new BasicColumnFamilyDefinition();
    // TODO static in schemaUtils
    columnFamilyDefinition.setKeyspaceName(SchemaUtils.TUTORIAL_KEYSPACE_NAME);
    columnFamilyDefinition.setName(CF_TOMBSTONE_DEMO);
    columnFamilyDefinition.setComparatorType(ComparatorType.UTF8TYPE);
    columnFamilyDefinition.setDefaultValidationClass(ComparatorType.UTF8TYPE.getClassName());
    columnFamilyDefinition.setKeyValidationClass(ComparatorType.UTF8TYPE.getClassName());
    ColumnFamilyDefinition cfDef = new ThriftCfDef(columnFamilyDefinition);
    schemaUtils.maybeCreate(cfDef);
  }

  private void createRows() {
    // create 3 'user' rows

    // - string key
    // - name
    // - email
    // - city


  }
}