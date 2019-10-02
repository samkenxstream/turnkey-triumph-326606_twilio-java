/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment extends Resource {
    private static final long serialVersionUID = 171611678539835L;

    /**
     * Create a EnvironmentReader to execute read.
     *
     * @param pathServiceSid The SID of the Service to read the Environment
     *                       resources from
     * @return EnvironmentReader capable of executing the read
     */
    public static EnvironmentReader reader(final String pathServiceSid) {
        return new EnvironmentReader(pathServiceSid);
    }

    /**
     * Create a EnvironmentFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Service to fetch the Environment
     *                       resource from
     * @param pathSid The SID of the Environment resource to fetch
     * @return EnvironmentFetcher capable of executing the fetch
     */
    public static EnvironmentFetcher fetcher(final String pathServiceSid,
                                             final String pathSid) {
        return new EnvironmentFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a EnvironmentCreator to execute create.
     *
     * @param pathServiceSid The SID of the Service to create the Environment
     *                       resource under
     * @param uniqueName An application-defined string that uniquely identifies the
     *                   Environment resource
     * @return EnvironmentCreator capable of executing the create
     */
    public static EnvironmentCreator creator(final String pathServiceSid,
                                             final String uniqueName) {
        return new EnvironmentCreator(pathServiceSid, uniqueName);
    }

    /**
     * Create a EnvironmentDeleter to execute delete.
     *
     * @param pathServiceSid The SID of the Service to delete the Environment
     *                       resource from
     * @param pathSid The SID that identifies the Environment resource to delete
     * @return EnvironmentDeleter capable of executing the delete
     */
    public static EnvironmentDeleter deleter(final String pathServiceSid,
                                             final String pathSid) {
        return new EnvironmentDeleter(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Environment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Environment object represented by the provided JSON
     */
    public static Environment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Environment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Environment object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Environment object represented by the provided JSON
     */
    public static Environment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Environment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String buildSid;
    private final String uniqueName;
    private final String domainSuffix;
    private final String domainName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Environment(@JsonProperty("sid")
                        final String sid,
                        @JsonProperty("account_sid")
                        final String accountSid,
                        @JsonProperty("service_sid")
                        final String serviceSid,
                        @JsonProperty("build_sid")
                        final String buildSid,
                        @JsonProperty("unique_name")
                        final String uniqueName,
                        @JsonProperty("domain_suffix")
                        final String domainSuffix,
                        @JsonProperty("domain_name")
                        final String domainName,
                        @JsonProperty("date_created")
                        final String dateCreated,
                        @JsonProperty("date_updated")
                        final String dateUpdated,
                        @JsonProperty("url")
                        final URI url,
                        @JsonProperty("links")
                        final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.buildSid = buildSid;
        this.uniqueName = uniqueName;
        this.domainSuffix = domainSuffix;
        this.domainName = domainName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The unique string that identifies the Environment resource.
     *
     * @return The unique string that identifies the Environment resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The SID of the Account that created the Environment resource.
     *
     * @return The SID of the Account that created the Environment resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the Service that the Environment resource is
     * associated with.
     *
     * @return The SID of the Service that the Environment resource is associated
     *         with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The SID of the build deployed in the environment.
     *
     * @return The SID of the build deployed in the environment
     */
    public final String getBuildSid() {
        return this.buildSid;
    }

    /**
     * Returns The An application-defined string that uniquely identifies the
     * Environment resource.
     *
     * @return An application-defined string that uniquely identifies the
     *         Environment resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The A URL-friendly name that represents the environment.
     *
     * @return A URL-friendly name that represents the environment
     */
    public final String getDomainSuffix() {
        return this.domainSuffix;
    }

    /**
     * Returns The The base domain name for all Functions and Assets deployed in the
     * environment.
     *
     * @return The base domain name for all Functions and Assets deployed in the
     *         environment
     */
    public final String getDomainName() {
        return this.domainName;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the Environment resource
     * was created.
     *
     * @return The ISO 8601 date and time in GMT when the Environment resource was
     *         created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the Environment resource
     * was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the Environment resource was
     *         last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The absolute URL of the Environment resource.
     *
     * @return The absolute URL of the Environment resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The URLs of the environment's nested resources.
     *
     * @return The URLs of the environment's nested resources
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Environment other = (Environment) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(buildSid, other.buildSid) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(domainSuffix, other.domainSuffix) &&
               Objects.equals(domainName, other.domainName) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            buildSid,
                            uniqueName,
                            domainSuffix,
                            domainName,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("buildSid", buildSid)
                          .add("uniqueName", uniqueName)
                          .add("domainSuffix", domainSuffix)
                          .add("domainName", domainName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}