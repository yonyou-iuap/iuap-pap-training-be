
-- ----------------------------
-- Table structure for IUAPD_ALLOWANCES
-- ----------------------------
DROP TABLE [IUAPD_ALLOWANCES]
GO
CREATE TABLE [IUAPD_ALLOWANCES] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NULL ,
[NAME] varchar(64) NULL ,
[SEX] int NULL ,
[DEPT] varchar(64) NULL ,
[POST_LEVEL] varchar(64) NULL ,
[SERVICE_YEARS] int NULL ,
[SERVICE_YEARS_COMPANY] int NULL ,
[YEAR] varchar(64) NULL ,
[MONTH] int NULL ,
[ALLOWANCE_TYPE] int NULL ,
[ALLOWANCE_STANDARD] decimal(10,2) NULL ,
[ALLOWANCE_ACTUAL] decimal(10,2) NULL ,
[EXDEEDS] int NULL ,
[APPLY_TIME] varchar(64) NULL ,
[PICK_TYPE] int NULL ,
[PICK_TIME] varchar(64) NULL ,
[REMARK] varchar(200) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[NAME2] varchar(64) NULL ,
[NAME3] varchar(64) NULL ,
[NAME4] varchar(64) NULL ,
[NAME5] varchar(64) NULL ,
[NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_EMERGENCY_CONTACT
-- ----------------------------
DROP TABLE [IUAPD_EMERGENCY_CONTACT]
GO
CREATE TABLE [IUAPD_EMERGENCY_CONTACT] (
[ID] varchar(64) NOT NULL ,
[PASSENGER_ID] varchar(64) NULL ,
[CONTACT_NAME] varchar(32) NULL ,
[CONTACT_PHONE] varchar(32) NULL ,
[CONTACT_RELATION] varchar(64) NULL ,
[REMARK] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[CONTACT_NAME2] varchar(64) NULL ,
[CONTACT_NAME3] varchar(64) NULL ,
[CONTACT_NAME4] varchar(64) NULL ,
[CONTACT_NAME5] varchar(64) NULL ,
[CONTACT_NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_GRID_TEMP
-- ----------------------------
DROP TABLE [IUAPD_GRID_TEMP]
GO
CREATE TABLE [IUAPD_GRID_TEMP] (
[ID] varchar(64) NOT NULL ,
[MODEL_CODE] varchar(255) NULL ,
[MODEL_NAME] varchar(255) NULL ,
[MODEL_TYPE] varchar(255) NULL ,
[MODEL_CONTENT] varchar(MAX) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[MODEL_NAME2] varchar(64) NULL ,
[MODEL_NAME3] varchar(64) NULL ,
[MODEL_NAME4] varchar(64) NULL ,
[MODEL_NAME5] varchar(64) NULL ,
[MODEL_NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_HELLOWORLD
-- ----------------------------
DROP TABLE [IUAPD_HELLOWORLD]
GO
CREATE TABLE [IUAPD_HELLOWORLD] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(50) NULL ,
[NAME] varchar(50) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PASSENGER
-- ----------------------------
DROP TABLE [IUAPD_PASSENGER]
GO
CREATE TABLE [IUAPD_PASSENGER] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NOT NULL ,
[NAME] varchar(64) NULL ,
[SEX] decimal(1) NULL ,
[DEPT] varchar(64) NULL ,
[PHONE] varchar(30) NULL ,
[IS_VIP] decimal(1) NULL ,
[GRADE] decimal(1) NULL ,
[EXPIRATION_DATE] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[NAME2] varchar(64) NULL ,
[NAME3] varchar(64) NULL ,
[NAME4] varchar(64) NULL ,
[NAME5] varchar(64) NULL ,
[NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PURCHASE_ORDER
-- ----------------------------
DROP TABLE [IUAPD_PURCHASE_ORDER]
GO
CREATE TABLE [IUAPD_PURCHASE_ORDER] (
[ID] varchar(64) NOT NULL ,
[ORDER_CODE] varchar(64) NULL ,
[ORDER_NAME] varchar(64) NULL ,
[ORDER_TYPE] int NULL ,
[ORDER_PRICE] decimal(10,2) NULL ,
[ORDER_USER] varchar(64) NULL ,
[ORDER_DEPT] varchar(64) NULL ,
[ORDER_DATE] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[ORDER_NAME2] varchar(64) NULL ,
[ORDER_NAME3] varchar(64) NULL ,
[ORDER_NAME4] varchar(64) NULL ,
[ORDER_NAME5] varchar(64) NULL ,
[ORDER_NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PURCHASE_ORDER_DETAIL
-- ----------------------------
DROP TABLE [IUAPD_PURCHASE_ORDER_DETAIL]
GO
CREATE TABLE [IUAPD_PURCHASE_ORDER_DETAIL] (
[ID] varchar(64) NOT NULL ,
[ORDER_ID] varchar(64) NULL ,
[DETAIL_NAME] varchar(64) NULL ,
[DETAIL_MODEL] varchar(64) NULL ,
[DETAIL_COUNT] int NULL ,
[DETAIL_DATE] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_RANKS
-- ----------------------------
DROP TABLE [IUAPD_RANKS]
GO
CREATE TABLE [IUAPD_RANKS] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(255) NULL ,
[TYPE] varchar(255) NULL ,
[GRADE] decimal(2) NULL ,
[POST_LEVEL] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TRAVELING_INFORMATION
-- ----------------------------
DROP TABLE [IUAPD_TRAVELING_INFORMATION]
GO
CREATE TABLE [IUAPD_TRAVELING_INFORMATION] (
[ID] varchar(64) NOT NULL ,
[PASSENGER_ID] varchar(64) NULL ,
[LINE] varchar(64) NULL ,
[STATION_BEGIN] varchar(64) NULL ,
[STATION_END] varchar(64) NULL ,
[COST] decimal(10,2) NULL ,
[PAY_STATUS] decimal(1) NULL ,
[REMARK] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[TRAVEL_TIME] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TREELIST
-- ----------------------------
DROP TABLE [IUAPD_TREELIST]
GO
CREATE TABLE [IUAPD_TREELIST] (
[ID] varchar(64) NOT NULL ,
[NAME] varchar(64) NULL ,
[IS_SON] decimal(1) NULL ,
[PARENTID] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[CODE] varchar(64) NULL ,
[NAME2] varchar(64) NULL ,
[NAME3] varchar(64) NULL ,
[NAME4] varchar(64) NULL ,
[NAME5] varchar(64) NULL ,
[NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TREELIST_DETAIL
-- ----------------------------
DROP TABLE [IUAPD_TREELIST_DETAIL]
GO
CREATE TABLE [IUAPD_TREELIST_DETAIL] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NULL ,
[NAME] varchar(64) NULL ,
[AGE] int NULL ,
[SEX] int NULL ,
[TREE_ID] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[NAME2] varchar(64) NULL ,
[NAME3] varchar(64) NULL ,
[NAME4] varchar(64) NULL ,
[NAME5] varchar(64) NULL ,
[NAME6] varchar(64) NULL 
)


GO

-- ----------------------------
-- Indexes structure for table IUAPD_EMERGENCY_CONTACT
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_EMERGENCY_CONTACT
-- ----------------------------
ALTER TABLE [IUAPD_EMERGENCY_CONTACT] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_GRID_TEMP
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_GRID_TEMP
-- ----------------------------
ALTER TABLE [IUAPD_GRID_TEMP] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_HELLOWORLD
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_HELLOWORLD
-- ----------------------------
ALTER TABLE [IUAPD_HELLOWORLD] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_PASSENGER
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_PASSENGER
-- ----------------------------
ALTER TABLE [IUAPD_PASSENGER] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_PURCHASE_ORDER
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_PURCHASE_ORDER
-- ----------------------------
ALTER TABLE [IUAPD_PURCHASE_ORDER] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_PURCHASE_ORDER_DETAIL
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_PURCHASE_ORDER_DETAIL
-- ----------------------------
ALTER TABLE [IUAPD_PURCHASE_ORDER_DETAIL] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_RANKS
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_RANKS
-- ----------------------------
ALTER TABLE [IUAPD_RANKS] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_TRAVELING_INFORMATION
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_TRAVELING_INFORMATION
-- ----------------------------
ALTER TABLE [IUAPD_TRAVELING_INFORMATION] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_TREELIST
-- ----------------------------
CREATE INDEX [name] ON [IUAPD_TREELIST]
([NAME] ASC) 
WITH (STATISTICS_NORECOMPUTE = ON)
GO

-- ----------------------------
-- Primary Key structure for table IUAPD_TREELIST
-- ----------------------------
ALTER TABLE [IUAPD_TREELIST] ADD PRIMARY KEY ([ID])
GO

-- ----------------------------
-- Indexes structure for table IUAPD_TREELIST_DETAIL
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table IUAPD_TREELIST_DETAIL
-- ----------------------------
ALTER TABLE [IUAPD_TREELIST_DETAIL] ADD PRIMARY KEY ([ID])
GO
