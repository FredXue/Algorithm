
-- CREATE HR Data SCHEME
CREATE TABLE dw_hr_d (
satisfaction_level Integer,
number_project Decimal,
average_montly_hours Decimal,
time_spend_company Decimal,
promotion_last_5years Decimal,
work_type String,
salary Integer
)
PARTITIONED BY (year STRING);

--LOAD Data
LOAD DATA LOCAL INPATH ‘workspace/hive/partitions/allHRdata2016’ 
INTO TABLE dw_hr_d
PARTITION (year="2016");


-- CREATE Grad Data SHEME
CREATE TABLE dw_graduation_d (
cip_xcode Integer,
major_number Decimal,
aw_level Decimal,
cto_talt Decimal,
cto_talt_m Decimal,
cto_talt_w Decimal,
caian_total Integer,
caian_men Decimal,
caian_woman Decimal,
asian_total Decimal,
asian_men Integer,
asian_women Decimal,
white_total Decimal,
white_man Decimal,
white_woman Integer,
)
PARTITIONED BY (year STRING);


--LOAD Data
LOAD DATA LOCAL INPATH ‘workspace/hive/partitions/graduationData‘
INTO TABLE dw_graduation_d
PARTITION (year=year);

--Analysis Sample code
Select * From
dw_graduation_d grad
left outer join
dw_hr_d hr
on hr.year = grad.year
