package com.generator.pojo;

import java.util.ArrayList;
import java.util.List;

public class DataInstructionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public DataInstructionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
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
     * This method corresponds to the database table data_instruction
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
     * This method corresponds to the database table data_instruction
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_instruction
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
     * This class corresponds to the database table data_instruction
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

        public Criteria andIdelementIsNull() {
            addCriterion("idElement is null");
            return (Criteria) this;
        }

        public Criteria andIdelementIsNotNull() {
            addCriterion("idElement is not null");
            return (Criteria) this;
        }

        public Criteria andIdelementEqualTo(String value) {
            addCriterion("idElement =", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementNotEqualTo(String value) {
            addCriterion("idElement <>", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementGreaterThan(String value) {
            addCriterion("idElement >", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementGreaterThanOrEqualTo(String value) {
            addCriterion("idElement >=", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementLessThan(String value) {
            addCriterion("idElement <", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementLessThanOrEqualTo(String value) {
            addCriterion("idElement <=", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementLike(String value) {
            addCriterion("idElement like", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementNotLike(String value) {
            addCriterion("idElement not like", value, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementIn(List<String> values) {
            addCriterion("idElement in", values, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementNotIn(List<String> values) {
            addCriterion("idElement not in", values, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementBetween(String value1, String value2) {
            addCriterion("idElement between", value1, value2, "idelement");
            return (Criteria) this;
        }

        public Criteria andIdelementNotBetween(String value1, String value2) {
            addCriterion("idElement not between", value1, value2, "idelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementIsNull() {
            addCriterion("chineseMeanElement is null");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementIsNotNull() {
            addCriterion("chineseMeanElement is not null");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementEqualTo(String value) {
            addCriterion("chineseMeanElement =", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementNotEqualTo(String value) {
            addCriterion("chineseMeanElement <>", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementGreaterThan(String value) {
            addCriterion("chineseMeanElement >", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementGreaterThanOrEqualTo(String value) {
            addCriterion("chineseMeanElement >=", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementLessThan(String value) {
            addCriterion("chineseMeanElement <", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementLessThanOrEqualTo(String value) {
            addCriterion("chineseMeanElement <=", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementLike(String value) {
            addCriterion("chineseMeanElement like", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementNotLike(String value) {
            addCriterion("chineseMeanElement not like", value, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementIn(List<String> values) {
            addCriterion("chineseMeanElement in", values, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementNotIn(List<String> values) {
            addCriterion("chineseMeanElement not in", values, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementBetween(String value1, String value2) {
            addCriterion("chineseMeanElement between", value1, value2, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andChinesemeanelementNotBetween(String value1, String value2) {
            addCriterion("chineseMeanElement not between", value1, value2, "chinesemeanelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementIsNull() {
            addCriterion("unitElement is null");
            return (Criteria) this;
        }

        public Criteria andUnitelementIsNotNull() {
            addCriterion("unitElement is not null");
            return (Criteria) this;
        }

        public Criteria andUnitelementEqualTo(String value) {
            addCriterion("unitElement =", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementNotEqualTo(String value) {
            addCriterion("unitElement <>", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementGreaterThan(String value) {
            addCriterion("unitElement >", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementGreaterThanOrEqualTo(String value) {
            addCriterion("unitElement >=", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementLessThan(String value) {
            addCriterion("unitElement <", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementLessThanOrEqualTo(String value) {
            addCriterion("unitElement <=", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementLike(String value) {
            addCriterion("unitElement like", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementNotLike(String value) {
            addCriterion("unitElement not like", value, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementIn(List<String> values) {
            addCriterion("unitElement in", values, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementNotIn(List<String> values) {
            addCriterion("unitElement not in", values, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementBetween(String value1, String value2) {
            addCriterion("unitElement between", value1, value2, "unitelement");
            return (Criteria) this;
        }

        public Criteria andUnitelementNotBetween(String value1, String value2) {
            addCriterion("unitElement not between", value1, value2, "unitelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementIsNull() {
            addCriterion("typeElement is null");
            return (Criteria) this;
        }

        public Criteria andTypeelementIsNotNull() {
            addCriterion("typeElement is not null");
            return (Criteria) this;
        }

        public Criteria andTypeelementEqualTo(String value) {
            addCriterion("typeElement =", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementNotEqualTo(String value) {
            addCriterion("typeElement <>", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementGreaterThan(String value) {
            addCriterion("typeElement >", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementGreaterThanOrEqualTo(String value) {
            addCriterion("typeElement >=", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementLessThan(String value) {
            addCriterion("typeElement <", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementLessThanOrEqualTo(String value) {
            addCriterion("typeElement <=", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementLike(String value) {
            addCriterion("typeElement like", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementNotLike(String value) {
            addCriterion("typeElement not like", value, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementIn(List<String> values) {
            addCriterion("typeElement in", values, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementNotIn(List<String> values) {
            addCriterion("typeElement not in", values, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementBetween(String value1, String value2) {
            addCriterion("typeElement between", value1, value2, "typeelement");
            return (Criteria) this;
        }

        public Criteria andTypeelementNotBetween(String value1, String value2) {
            addCriterion("typeElement not between", value1, value2, "typeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementIsNull() {
            addCriterion("scopeElement is null");
            return (Criteria) this;
        }

        public Criteria andScopeelementIsNotNull() {
            addCriterion("scopeElement is not null");
            return (Criteria) this;
        }

        public Criteria andScopeelementEqualTo(String value) {
            addCriterion("scopeElement =", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementNotEqualTo(String value) {
            addCriterion("scopeElement <>", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementGreaterThan(String value) {
            addCriterion("scopeElement >", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementGreaterThanOrEqualTo(String value) {
            addCriterion("scopeElement >=", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementLessThan(String value) {
            addCriterion("scopeElement <", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementLessThanOrEqualTo(String value) {
            addCriterion("scopeElement <=", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementLike(String value) {
            addCriterion("scopeElement like", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementNotLike(String value) {
            addCriterion("scopeElement not like", value, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementIn(List<String> values) {
            addCriterion("scopeElement in", values, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementNotIn(List<String> values) {
            addCriterion("scopeElement not in", values, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementBetween(String value1, String value2) {
            addCriterion("scopeElement between", value1, value2, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andScopeelementNotBetween(String value1, String value2) {
            addCriterion("scopeElement not between", value1, value2, "scopeelement");
            return (Criteria) this;
        }

        public Criteria andEigenvalueIsNull() {
            addCriterion("eigenvalue is null");
            return (Criteria) this;
        }

        public Criteria andEigenvalueIsNotNull() {
            addCriterion("eigenvalue is not null");
            return (Criteria) this;
        }

        public Criteria andEigenvalueEqualTo(String value) {
            addCriterion("eigenvalue =", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueNotEqualTo(String value) {
            addCriterion("eigenvalue <>", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueGreaterThan(String value) {
            addCriterion("eigenvalue >", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueGreaterThanOrEqualTo(String value) {
            addCriterion("eigenvalue >=", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueLessThan(String value) {
            addCriterion("eigenvalue <", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueLessThanOrEqualTo(String value) {
            addCriterion("eigenvalue <=", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueLike(String value) {
            addCriterion("eigenvalue like", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueNotLike(String value) {
            addCriterion("eigenvalue not like", value, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueIn(List<String> values) {
            addCriterion("eigenvalue in", values, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueNotIn(List<String> values) {
            addCriterion("eigenvalue not in", values, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueBetween(String value1, String value2) {
            addCriterion("eigenvalue between", value1, value2, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andEigenvalueNotBetween(String value1, String value2) {
            addCriterion("eigenvalue not between", value1, value2, "eigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueIsNull() {
            addCriterion("instructionEigenvalue is null");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueIsNotNull() {
            addCriterion("instructionEigenvalue is not null");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueEqualTo(String value) {
            addCriterion("instructionEigenvalue =", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueNotEqualTo(String value) {
            addCriterion("instructionEigenvalue <>", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueGreaterThan(String value) {
            addCriterion("instructionEigenvalue >", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueGreaterThanOrEqualTo(String value) {
            addCriterion("instructionEigenvalue >=", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueLessThan(String value) {
            addCriterion("instructionEigenvalue <", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueLessThanOrEqualTo(String value) {
            addCriterion("instructionEigenvalue <=", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueLike(String value) {
            addCriterion("instructionEigenvalue like", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueNotLike(String value) {
            addCriterion("instructionEigenvalue not like", value, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueIn(List<String> values) {
            addCriterion("instructionEigenvalue in", values, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueNotIn(List<String> values) {
            addCriterion("instructionEigenvalue not in", values, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueBetween(String value1, String value2) {
            addCriterion("instructionEigenvalue between", value1, value2, "instructioneigenvalue");
            return (Criteria) this;
        }

        public Criteria andInstructioneigenvalueNotBetween(String value1, String value2) {
            addCriterion("instructionEigenvalue not between", value1, value2, "instructioneigenvalue");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table data_instruction
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
     * This class corresponds to the database table data_instruction
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