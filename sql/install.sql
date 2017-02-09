SPOOL .\init.log

@@createTables.sql
@@createIncUsers.sql
@@createIncBids.sql
@@createIncItems.sql
@@fillData.sql

SPOOL OFF