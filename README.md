# Drools MapReduce

This integration framework allows users to create MapReduce jobs using the Drools framework. Providing users of all technical levels the capability to author MapReduce jobs with the Drools framework allows experts in various data analysis methods to directly author and manage MapReduce jobs.

## Artifacts

* drools-mapreduce-parent : parent artifact that manages dependency versions
* drools-mapreduce-core : core library that provides internal MapReduce interface to Drools
* drools-mapreduce-hadoop : bridge between Hadoop and internal MapReduce interface
* drools-mapreduce-hadoop-example : example artifact to upload and run MapReduce job in Hadoop
* drools-mapreduce-infinispan : bridge between Infinispan and internal MapReduce interface

## Supported MapReduce Implementations

Currently this framework supports both Hadoop and Infinispan as MapReduce implementations through the `drools-mapreduce-hadoop` and `drools-mapreduce-infinispan` artifacts respectively.
