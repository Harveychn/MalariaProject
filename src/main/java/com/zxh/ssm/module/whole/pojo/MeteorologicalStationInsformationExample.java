package com.zxh.ssm.module.whole.pojo;

import java.util.ArrayList;
import java.util.List;

public class MeteorologicalStationInsformationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public MeteorologicalStationInsformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDistrictstationnumIsNull() {
            addCriterion("districtStationNum is null");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumIsNotNull() {
            addCriterion("districtStationNum is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumEqualTo(Integer value) {
            addCriterion("districtStationNum =", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumNotEqualTo(Integer value) {
            addCriterion("districtStationNum <>", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumGreaterThan(Integer value) {
            addCriterion("districtStationNum >", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("districtStationNum >=", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumLessThan(Integer value) {
            addCriterion("districtStationNum <", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumLessThanOrEqualTo(Integer value) {
            addCriterion("districtStationNum <=", value, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumIn(List<Integer> values) {
            addCriterion("districtStationNum in", values, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumNotIn(List<Integer> values) {
            addCriterion("districtStationNum not in", values, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumBetween(Integer value1, Integer value2) {
            addCriterion("districtStationNum between", value1, value2, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andDistrictstationnumNotBetween(Integer value1, Integer value2) {
            addCriterion("districtStationNum not between", value1, value2, "districtstationnum");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNull() {
            addCriterion("stationName is null");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNotNull() {
            addCriterion("stationName is not null");
            return (Criteria) this;
        }

        public Criteria andStationnameEqualTo(String value) {
            addCriterion("stationName =", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotEqualTo(String value) {
            addCriterion("stationName <>", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThan(String value) {
            addCriterion("stationName >", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThanOrEqualTo(String value) {
            addCriterion("stationName >=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThan(String value) {
            addCriterion("stationName <", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThanOrEqualTo(String value) {
            addCriterion("stationName <=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLike(String value) {
            addCriterion("stationName like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotLike(String value) {
            addCriterion("stationName not like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameIn(List<String> values) {
            addCriterion("stationName in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotIn(List<String> values) {
            addCriterion("stationName not in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameBetween(String value1, String value2) {
            addCriterion("stationName between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotBetween(String value1, String value2) {
            addCriterion("stationName not between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andProvinvesIsNull() {
            addCriterion("provinves is null");
            return (Criteria) this;
        }

        public Criteria andProvinvesIsNotNull() {
            addCriterion("provinves is not null");
            return (Criteria) this;
        }

        public Criteria andProvinvesEqualTo(String value) {
            addCriterion("provinves =", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesNotEqualTo(String value) {
            addCriterion("provinves <>", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesGreaterThan(String value) {
            addCriterion("provinves >", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesGreaterThanOrEqualTo(String value) {
            addCriterion("provinves >=", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesLessThan(String value) {
            addCriterion("provinves <", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesLessThanOrEqualTo(String value) {
            addCriterion("provinves <=", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesLike(String value) {
            addCriterion("provinves like", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesNotLike(String value) {
            addCriterion("provinves not like", value, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesIn(List<String> values) {
            addCriterion("provinves in", values, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesNotIn(List<String> values) {
            addCriterion("provinves not in", values, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesBetween(String value1, String value2) {
            addCriterion("provinves between", value1, value2, "provinves");
            return (Criteria) this;
        }

        public Criteria andProvinvesNotBetween(String value1, String value2) {
            addCriterion("provinves not between", value1, value2, "provinves");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Integer value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Integer value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Integer value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Integer value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Integer value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Integer value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Integer> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Integer> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Integer value1, Integer value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Integer value1, Integer value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Integer value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Integer value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Integer value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Integer value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Integer value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Integer value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Integer> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Integer> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Integer value1, Integer value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Integer value1, Integer value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNull() {
            addCriterion("altitude is null");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNotNull() {
            addCriterion("altitude is not null");
            return (Criteria) this;
        }

        public Criteria andAltitudeEqualTo(Integer value) {
            addCriterion("altitude =", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotEqualTo(Integer value) {
            addCriterion("altitude <>", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThan(Integer value) {
            addCriterion("altitude >", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("altitude >=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThan(Integer value) {
            addCriterion("altitude <", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThanOrEqualTo(Integer value) {
            addCriterion("altitude <=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIn(List<Integer> values) {
            addCriterion("altitude in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotIn(List<Integer> values) {
            addCriterion("altitude not in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeBetween(Integer value1, Integer value2) {
            addCriterion("altitude between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("altitude not between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andStartyearIsNull() {
            addCriterion("startYear is null");
            return (Criteria) this;
        }

        public Criteria andStartyearIsNotNull() {
            addCriterion("startYear is not null");
            return (Criteria) this;
        }

        public Criteria andStartyearEqualTo(Integer value) {
            addCriterion("startYear =", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearNotEqualTo(Integer value) {
            addCriterion("startYear <>", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearGreaterThan(Integer value) {
            addCriterion("startYear >", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearGreaterThanOrEqualTo(Integer value) {
            addCriterion("startYear >=", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearLessThan(Integer value) {
            addCriterion("startYear <", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearLessThanOrEqualTo(Integer value) {
            addCriterion("startYear <=", value, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearIn(List<Integer> values) {
            addCriterion("startYear in", values, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearNotIn(List<Integer> values) {
            addCriterion("startYear not in", values, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearBetween(Integer value1, Integer value2) {
            addCriterion("startYear between", value1, value2, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartyearNotBetween(Integer value1, Integer value2) {
            addCriterion("startYear not between", value1, value2, "startyear");
            return (Criteria) this;
        }

        public Criteria andStartmonthIsNull() {
            addCriterion("startMonth is null");
            return (Criteria) this;
        }

        public Criteria andStartmonthIsNotNull() {
            addCriterion("startMonth is not null");
            return (Criteria) this;
        }

        public Criteria andStartmonthEqualTo(Integer value) {
            addCriterion("startMonth =", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotEqualTo(Integer value) {
            addCriterion("startMonth <>", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthGreaterThan(Integer value) {
            addCriterion("startMonth >", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("startMonth >=", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthLessThan(Integer value) {
            addCriterion("startMonth <", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthLessThanOrEqualTo(Integer value) {
            addCriterion("startMonth <=", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthIn(List<Integer> values) {
            addCriterion("startMonth in", values, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotIn(List<Integer> values) {
            addCriterion("startMonth not in", values, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthBetween(Integer value1, Integer value2) {
            addCriterion("startMonth between", value1, value2, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("startMonth not between", value1, value2, "startmonth");
            return (Criteria) this;
        }

        public Criteria andEndyearIsNull() {
            addCriterion("endYear is null");
            return (Criteria) this;
        }

        public Criteria andEndyearIsNotNull() {
            addCriterion("endYear is not null");
            return (Criteria) this;
        }

        public Criteria andEndyearEqualTo(Integer value) {
            addCriterion("endYear =", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearNotEqualTo(Integer value) {
            addCriterion("endYear <>", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearGreaterThan(Integer value) {
            addCriterion("endYear >", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearGreaterThanOrEqualTo(Integer value) {
            addCriterion("endYear >=", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearLessThan(Integer value) {
            addCriterion("endYear <", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearLessThanOrEqualTo(Integer value) {
            addCriterion("endYear <=", value, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearIn(List<Integer> values) {
            addCriterion("endYear in", values, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearNotIn(List<Integer> values) {
            addCriterion("endYear not in", values, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearBetween(Integer value1, Integer value2) {
            addCriterion("endYear between", value1, value2, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndyearNotBetween(Integer value1, Integer value2) {
            addCriterion("endYear not between", value1, value2, "endyear");
            return (Criteria) this;
        }

        public Criteria andEndmonthIsNull() {
            addCriterion("endMonth is null");
            return (Criteria) this;
        }

        public Criteria andEndmonthIsNotNull() {
            addCriterion("endMonth is not null");
            return (Criteria) this;
        }

        public Criteria andEndmonthEqualTo(Integer value) {
            addCriterion("endMonth =", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotEqualTo(Integer value) {
            addCriterion("endMonth <>", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthGreaterThan(Integer value) {
            addCriterion("endMonth >", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("endMonth >=", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthLessThan(Integer value) {
            addCriterion("endMonth <", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthLessThanOrEqualTo(Integer value) {
            addCriterion("endMonth <=", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthIn(List<Integer> values) {
            addCriterion("endMonth in", values, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotIn(List<Integer> values) {
            addCriterion("endMonth not in", values, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthBetween(Integer value1, Integer value2) {
            addCriterion("endMonth between", value1, value2, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("endMonth not between", value1, value2, "endmonth");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementIsNull() {
            addCriterion("lackMeasurement is null");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementIsNotNull() {
            addCriterion("lackMeasurement is not null");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementEqualTo(String value) {
            addCriterion("lackMeasurement =", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementNotEqualTo(String value) {
            addCriterion("lackMeasurement <>", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementGreaterThan(String value) {
            addCriterion("lackMeasurement >", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementGreaterThanOrEqualTo(String value) {
            addCriterion("lackMeasurement >=", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementLessThan(String value) {
            addCriterion("lackMeasurement <", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementLessThanOrEqualTo(String value) {
            addCriterion("lackMeasurement <=", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementLike(String value) {
            addCriterion("lackMeasurement like", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementNotLike(String value) {
            addCriterion("lackMeasurement not like", value, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementIn(List<String> values) {
            addCriterion("lackMeasurement in", values, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementNotIn(List<String> values) {
            addCriterion("lackMeasurement not in", values, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementBetween(String value1, String value2) {
            addCriterion("lackMeasurement between", value1, value2, "lackmeasurement");
            return (Criteria) this;
        }

        public Criteria andLackmeasurementNotBetween(String value1, String value2) {
            addCriterion("lackMeasurement not between", value1, value2, "lackmeasurement");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table meteorological_station_insformation
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}