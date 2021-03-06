/**
 * Copyright 2016-2017 Symphony Integrations - Symphony LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.symphonyoss.integration.webhook.parser.metadata;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Model class that represents each JSON node of Entity JSON.
 *
 * Each node must have the required fields type and version.
 *
 * Each node may have {@link String} objects and nested {@link EntityObject} objects
 *
 * Created by rsanchez on 30/03/17.
 */
@JsonInclude(NON_NULL)
public class EntityObject {

  private String type;

  private String version;

  private Map<String, Object> content = new LinkedHashMap<>();

  public EntityObject() {}

  public EntityObject(String type, String version) {
    this.type = type;
    this.version = version;
  }

  public String getType() {
    return type;
  }

  public String getVersion() {
    return version;
  }

  @JsonAnyGetter
  public Map<String, Object> getContent() {
    return content;
  }

  @JsonAnySetter
  public void addContent(String key, Object content) {
    this.content.put(key, content);
  }
}
