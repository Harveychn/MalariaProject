package com.generator.pojo;

public class PostCode {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post_code.postalcode
     *
     * @mbggenerated
     */
    private Integer postalcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post_code.provinceCityAuPrefecture
     *
     * @mbggenerated
     */
    private String provincecityauprefecture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post_code.munDistrictsCountycityCountyAuCounty
     *
     * @mbggenerated
     */
    private String mundistrictscountycitycountyaucounty;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post_code.postalcode
     *
     * @return the value of post_code.postalcode
     *
     * @mbggenerated
     */
    public Integer getPostalcode() {
        return postalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post_code.postalcode
     *
     * @param postalcode the value for post_code.postalcode
     *
     * @mbggenerated
     */
    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post_code.provinceCityAuPrefecture
     *
     * @return the value of post_code.provinceCityAuPrefecture
     *
     * @mbggenerated
     */
    public String getProvincecityauprefecture() {
        return provincecityauprefecture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post_code.provinceCityAuPrefecture
     *
     * @param provincecityauprefecture the value for post_code.provinceCityAuPrefecture
     *
     * @mbggenerated
     */
    public void setProvincecityauprefecture(String provincecityauprefecture) {
        this.provincecityauprefecture = provincecityauprefecture == null ? null : provincecityauprefecture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post_code.munDistrictsCountycityCountyAuCounty
     *
     * @return the value of post_code.munDistrictsCountycityCountyAuCounty
     *
     * @mbggenerated
     */
    public String getMundistrictscountycitycountyaucounty() {
        return mundistrictscountycitycountyaucounty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post_code.munDistrictsCountycityCountyAuCounty
     *
     * @param mundistrictscountycitycountyaucounty the value for post_code.munDistrictsCountycityCountyAuCounty
     *
     * @mbggenerated
     */
    public void setMundistrictscountycitycountyaucounty(String mundistrictscountycitycountyaucounty) {
        this.mundistrictscountycitycountyaucounty = mundistrictscountycitycountyaucounty == null ? null : mundistrictscountycitycountyaucounty.trim();
    }
}