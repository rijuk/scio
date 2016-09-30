/*
 * Copyright 2016 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.scio.examples.common

import com.google.api.services.bigquery.model.TableReference
import com.google.cloud.dataflow.examples.common._
import com.google.cloud.dataflow.sdk.io.BigQueryIO
import com.google.cloud.dataflow.sdk.options.DataflowPipelineOptions

trait ExampleOptions
  extends DataflowPipelineOptions
  with DataflowExampleOptions
  with ExampleBigQueryTableOptions
  with ExamplePubsubTopicOptions

object ExampleOptions {
  def bigQueryTable(options: ExampleOptions): String =
    BigQueryIO.toTableSpec(new TableReference()
      .setProjectId(options.getProject)
      .setDatasetId(options.getBigQueryDataset)
      .setTableId(options.getBigQueryTable))
}
