package com.polidea.cockpitplugin.generator

import com.polidea.cockpit.core.CockpitParam
import com.polidea.cockpit.core.type.CockpitAction
import com.polidea.cockpit.core.type.CockpitColor
import com.polidea.cockpit.core.type.CockpitListType
import com.polidea.cockpit.core.type.CockpitReadOnly
import kotlin.test.Test
import kotlin.test.assertEquals


class DebugCockpitGeneratorTest {

    private val cockpitGenerator = DebugCockpitGenerator()

    @Test
    fun createGetterMethodSpecForDoubleParamTest() {
        val doubleGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam("doubleParam", 3.0)

        val expectedDoubleGetterMethodSpecString = """
            |public static double getDoubleParam() {
            |  return (double) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("doubleParam");
            |}"""
        assertEquals(expectedDoubleGetterMethodSpecString.trimMargin(), doubleGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForDoubleParamTest() {
        val doubleSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("doubleParam", 3.0)

        val expectedDoubleSetterMethodSpecString = """
            |public static void setDoubleParam(double doubleParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("doubleParam", doubleParam);
            |}"""
        assertEquals(expectedDoubleSetterMethodSpecString.trimMargin(), doubleSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForIntParamTest() {
        val intGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam("integerParam", 2)

        val expectedIntegerGetterMethodSpecString = """
            |public static int getIntegerParam() {
            |  return (int) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("integerParam");
            |}"""
        assertEquals(expectedIntegerGetterMethodSpecString.trimMargin(), intGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForIntParamTest() {
        val intSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("integerParam", 2)

        val expectedDoubleSetterMethodSpecString = """
            |public static void setIntegerParam(int integerParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("integerParam", integerParam);
            |}"""
        assertEquals(expectedDoubleSetterMethodSpecString.trimMargin(), intSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForBooleanParamTest() {
        val booleanGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam("booleanParam", false)

        val expectedBooleanGetterMethodSpecString = """
            |public static boolean isBooleanParam() {
            |  return (boolean) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("booleanParam");
            |}"""
        assertEquals(expectedBooleanGetterMethodSpecString.trimMargin(), booleanGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForBooleanParamTest() {
        val booleanSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("booleanParam", false)

        val expectedBooleanSetterMethodSpecString = """
            |public static void setBooleanParam(boolean booleanParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("booleanParam", booleanParam);
            |}"""
        assertEquals(expectedBooleanSetterMethodSpecString.trimMargin(), booleanSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForStringParamTest() {
        val stringGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam("stringParam", "testValue")

        val expectedStringGetterMethodSpecString = """
            |public static java.lang.String getStringParam() {
            |  return (java.lang.String) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stringParam");
            |}"""
        assertEquals(expectedStringGetterMethodSpecString.trimMargin(), stringGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForRangeIntParamTest() {
        val rangeIntGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForRangeParam("rangeIntParam", 1)

        val expectedRangeIntGetterMethodSpecString = """
            |public static int getRangeIntParam() {
            |  com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer> value = (com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("rangeIntParam");
            |  return cockpitRangeIntegerMapper.unwrap(value);
            |}"""

        assertEquals(expectedRangeIntGetterMethodSpecString.trimMargin(), rangeIntGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForRangeIntParamTest() {
        val rangeIntSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("rangeIntParam", 1)

        val expectedRangeIntSetterMethodSpecString = """
            |public static void setRangeIntParam(int rangeIntParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("rangeIntParam", rangeIntParam);
            |}"""
        assertEquals(expectedRangeIntSetterMethodSpecString.trimMargin(), rangeIntSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForRangeDoubleParamTest() {
        val rangeDoubleGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForRangeParam("rangeDoubleParam", 1.0)

        val expectedRangeDoubleGetterMethodSpecString = """
            |public static double getRangeDoubleParam() {
            |  com.polidea.cockpit.core.type.CockpitRange<java.lang.Double> value = (com.polidea.cockpit.core.type.CockpitRange<java.lang.Double>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("rangeDoubleParam");
            |  return cockpitRangeDoubleMapper.unwrap(value);
            |}"""

        assertEquals(expectedRangeDoubleGetterMethodSpecString.trimMargin(), rangeDoubleGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForRangeDoubleParamTest() {
        val rangeDoubleSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("rangeDoubleParam", 1.0)

        val expectedRangeDoubleSetterMethodSpecString = """
            |public static void setRangeDoubleParam(double rangeDoubleParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("rangeDoubleParam", rangeDoubleParam);
            |}"""
        assertEquals(expectedRangeDoubleSetterMethodSpecString.trimMargin(), rangeDoubleSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForStringParamTest() {
        val stringSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam("stringParam", "testValue")

        val expectedStringSetterMethodSpecString = """
            |public static void setStringParam(java.lang.String stringParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("stringParam", stringParam);
            |}"""
        assertEquals(expectedStringSetterMethodSpecString.trimMargin(), stringSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForReadOnlyParamTest() {
        val readOnlySetterMethodSpec = cockpitGenerator.createSetterMethodSpecForReadOnlyParam("readOnlyParam", CockpitReadOnly("testValue"))

        val expectedReadOnlySetterMethodSpecString = """
            |public static void setReadOnlyParam(java.lang.String readOnlyParam) {
            |  com.polidea.cockpit.core.type.CockpitReadOnly value = cockpitReadOnlyMapper.wrap(readOnlyParam);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("readOnlyParam", value);
            |}"""
        assertEquals(expectedReadOnlySetterMethodSpecString.trimMargin(), readOnlySetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForStepIntParamTest() {
        val stepIntSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForStepParam("stepIntParam", 1)

        val expectedStepIntSetterMethodSpecString = """
            |public static void setStepIntParam(int stepIntParam) {
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer> base = (com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stepIntParam");
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer> value = cockpitStepIntegerMapper.wrap(base, stepIntParam);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("stepIntParam", value);
            |}"""
        assertEquals(expectedStepIntSetterMethodSpecString.trimMargin(), stepIntSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForStepIntParamTest() {
        val stepIntGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForStepParam("stepIntParam", 1)

        val expectedStepIntGetterMethodSpecString = """
            |public static int getStepIntParam() {
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer> value = (com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stepIntParam");
            |  return cockpitStepIntegerMapper.unwrap(value);
            |}"""
        assertEquals(expectedStepIntGetterMethodSpecString.trimMargin(), stepIntGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForStepDoubleParamTest() {
        val stepDeoubleSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForStepParam("stepDoubleParam", 1.0)

        val expectedStepDoubleSetterMethodSpecString = """
            |public static void setStepDoubleParam(double stepDoubleParam) {
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Double> base = (com.polidea.cockpit.core.type.CockpitStep<java.lang.Double>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stepDoubleParam");
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Double> value = cockpitStepDoubleMapper.wrap(base, stepDoubleParam);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("stepDoubleParam", value);
            |}"""
        assertEquals(expectedStepDoubleSetterMethodSpecString.trimMargin(), stepDeoubleSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForStepDoubleParamTest() {
        val stepIntGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForStepParam("stepDoubleParam", 1.0)

        val expectedStepDoubleGetterMethodSpecString = """
            |public static double getStepDoubleParam() {
            |  com.polidea.cockpit.core.type.CockpitStep<java.lang.Double> value = (com.polidea.cockpit.core.type.CockpitStep<java.lang.Double>) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stepDoubleParam");
            |  return cockpitStepDoubleMapper.unwrap(value);
            |}"""
        assertEquals(expectedStepDoubleGetterMethodSpecString.trimMargin(), stepIntGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForBooleanParamTest() {
        val booleanParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam("boolParam", false)

        val expectedBooleanParamChangeListenerMethodSpecString = """
            |public static void addOnBoolParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Boolean> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("boolParam", listener);
            |}"""
        assertEquals(expectedBooleanParamChangeListenerMethodSpecString.trimMargin(), booleanParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForIntParamTest() {
        val integerParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam("intParam", 0)

        val expectedIntegerParamChangeListenerMethodSpecString = """
            |public static void addOnIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("intParam", listener);
            |}"""
        assertEquals(expectedIntegerParamChangeListenerMethodSpecString.trimMargin(), integerParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForDoubleParamTest() {
        val doubleParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam("doubleParam", .0)

        val expectedDoubleParamChangeListenerMethodSpecString = """
            |public static void addOnDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("doubleParam", listener);
            |}"""
        assertEquals(expectedDoubleParamChangeListenerMethodSpecString.trimMargin(), doubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForStringParamTest() {
        val stringParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam("stringParam", "")

        val expectedStringParamChangeListenerMethodSpecString = """
            |public static void addOnStringParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.String> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("stringParam", listener);
            |}"""
        assertEquals(expectedStringParamChangeListenerMethodSpecString.trimMargin(), stringParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForStepIntParamTest() {
        val stepStepParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForStepParam("stepIntParam", 1)

        val expectedStepIntParamChangeListenerMethodSpecString = """
            |public static void addOnStepIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer>> stepIntParamListener = new com.polidea.cockpit.mapper.MappingPropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer>, java.lang.Integer>(listener, cockpitStepIntegerMapper);
            |  stepIntegerListenerMap.put(listener, stepIntParamListener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("stepIntParam", stepIntParamListener);
            |}"""
        assertEquals(expectedStepIntParamChangeListenerMethodSpecString.trimMargin(), stepStepParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForStepDoubleParamTest() {
        val stepStepParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForStepParam("stepDoubleParam", 1.0)

        val expectedStepDoubleParamChangeListenerMethodSpecString = """
            |public static void addOnStepDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Double>> stepDoubleParamListener = new com.polidea.cockpit.mapper.MappingPropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Double>, java.lang.Double>(listener, cockpitStepDoubleMapper);
            |  stepDoubleListenerMap.put(listener, stepDoubleParamListener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("stepDoubleParam", stepDoubleParamListener);
            |}"""
        assertEquals(expectedStepDoubleParamChangeListenerMethodSpecString.trimMargin(), stepStepParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForRangeIntParamTest() {
        val rangeIntParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForRangeParam("rangeIntParam", 1)

        val expectedRangeIntParamChangeListenerMethodSpecString = """
            |public static void addOnRangeIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer>> rangeIntParamListener = new com.polidea.cockpit.mapper.MappingPropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer>, java.lang.Integer>(listener, cockpitRangeIntegerMapper);
            |  rangeIntegerListenerMap.put(listener, rangeIntParamListener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("rangeIntParam", rangeIntParamListener);
            |}"""
        assertEquals(expectedRangeIntParamChangeListenerMethodSpecString.trimMargin(), rangeIntParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForRangeDoubleParamTest() {
        val rangeDoubleParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForRangeParam("rangeDoubleParam", 1.0)

        val expectedRangeDoubleParamChangeListenerMethodSpecString = """
            |public static void addOnRangeDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Double>> rangeDoubleParamListener = new com.polidea.cockpit.mapper.MappingPropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Double>, java.lang.Double>(listener, cockpitRangeDoubleMapper);
            |  rangeDoubleListenerMap.put(listener, rangeDoubleParamListener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("rangeDoubleParam", rangeDoubleParamListener);
            |}"""
        assertEquals(expectedRangeDoubleParamChangeListenerMethodSpecString.trimMargin(), rangeDoubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddActionRequestCallbackMethodSpecForStringParamTest() {
        val actionCallbackMethodSpec = cockpitGenerator.createAddActionRequestCallbackMethodSpecForParam(CockpitParam("value", CockpitAction("show")))

        val expectedActionRequestCallbackMethodSpecString = """
            |public static void addValueActionRequestCallback(
            |    com.polidea.cockpit.event.ActionRequestCallback callback) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addActionRequestCallback("value", callback);
            |}"""
        assertEquals(expectedActionRequestCallbackMethodSpecString.trimMargin(), actionCallbackMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForCockpitColorParamTest() {
        val colorParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForColorParam("colorParam", CockpitColor("#112233"))

        val expectedStringParamChangeListenerMethodSpecString = """
            |public static void addOnColorParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.String> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitColor> colorParamListener = new com.polidea.cockpit.mapper.MappingPropertyChangeListener<com.polidea.cockpit.core.type.CockpitColor, java.lang.String>(listener, cockpitColorMapper);
            |  colorListenerMap.put(listener, colorParamListener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("colorParam", colorParamListener);
            |}"""
        assertEquals(expectedStringParamChangeListenerMethodSpecString.trimMargin(), colorParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForBooleanParamTest() {
        val booleanParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam("boolParam", false)

        val expectedBooleanParamChangeListenerMethodSpecString = """
            |public static void removeOnBoolParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Boolean> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("boolParam", listener);
            |}"""
        assertEquals(expectedBooleanParamChangeListenerMethodSpecString.trimMargin(), booleanParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForIntParamTest() {
        val integerParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam("intParam", 0)

        val expectedIntegerParamChangeListenerMethodSpecString = """
            |public static void removeOnIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("intParam", listener);
            |}"""
        assertEquals(expectedIntegerParamChangeListenerMethodSpecString.trimMargin(), integerParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForDoubleParamTest() {
        val doubleParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam("doubleParam", .0)

        val expectedDoubleParamChangeListenerMethodSpecString = """
            |public static void removeOnDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("doubleParam", listener);
            |}"""
        assertEquals(expectedDoubleParamChangeListenerMethodSpecString.trimMargin(), doubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForStringParamTest() {
        val stringParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam("stringParam", "")

        val expectedStringParamChangeListenerMethodSpecString = """
            |public static void removeOnStringParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.String> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("stringParam", listener);
            |}"""
        assertEquals(expectedStringParamChangeListenerMethodSpecString.trimMargin(), stringParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveActionRequestCallbackMethodSpecForStringParamTest() {
        val actionCallbackMethodSpec = cockpitGenerator.createRemoveActionRequestCallbackMethodSpecForParam(CockpitParam("value", CockpitAction("show")))

        val expectedActionRequestCallbackMethodSpecString = """
            |public static void removeValueActionRequestCallback(
            |    com.polidea.cockpit.event.ActionRequestCallback callback) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeActionRequestCallback("value", callback);
            |}"""
        assertEquals(expectedActionRequestCallbackMethodSpecString.trimMargin(), actionCallbackMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForColorParamTest() {
        val colorParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForColorParam("colorParam", CockpitColor("#112233"))

        val expectedColorParamChangeListenerMethodSpecString = """
            |public static void removeOnColorParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.String> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitColor> colorParamListener = colorListenerMap.get(listener);
            |  colorListenerMap.remove(listener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("colorParam", colorParamListener);
            |}"""

        assertEquals(expectedColorParamChangeListenerMethodSpecString.trimMargin(), colorParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForStepIntParamTest() {
        val stepIntParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForStepParam("stepInt", 1)

        val expectedStepIntParamChangeListenerMethodSpecString = """
            |public static void removeOnStepIntChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Integer>> stepIntListener = stepIntegerListenerMap.get(listener);
            |  stepIntegerListenerMap.remove(listener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("stepInt", stepIntListener);
            |}"""

        assertEquals(expectedStepIntParamChangeListenerMethodSpecString.trimMargin(), stepIntParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForStepDoubleParamTest() {
        val stepDoubleParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForStepParam("stepDouble", 1.0)

        val expectedStepDoubleParamChangeListenerMethodSpecString = """
            |public static void removeOnStepDoubleChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitStep<java.lang.Double>> stepDoubleListener = stepDoubleListenerMap.get(listener);
            |  stepDoubleListenerMap.remove(listener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("stepDouble", stepDoubleListener);
            |}"""

        assertEquals(expectedStepDoubleParamChangeListenerMethodSpecString.trimMargin(), stepDoubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForRangeIntParamTest() {
        val rangeIntParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForRangeParam("rangeInt", 1)

        val expectedRangeIntParamChangeListenerMethodSpecString = """
            |public static void removeOnRangeIntChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer>> rangeIntListener = rangeIntegerListenerMap.get(listener);
            |  rangeIntegerListenerMap.remove(listener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("rangeInt", rangeIntListener);
            |}"""

        assertEquals(expectedRangeIntParamChangeListenerMethodSpecString.trimMargin(), rangeIntParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForRangeDoubleParamTest() {
        val rangeDoubleParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForRangeParam("rangeDouble", 1.0)

        val expectedRangeDoubleParamChangeListenerMethodSpecString = """
            |public static void removeOnRangeDoubleChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double> listener) {
            |  com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Double>> rangeDoubleListener = rangeDoubleListenerMap.get(listener);
            |  rangeDoubleListenerMap.remove(listener);
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("rangeDouble", rangeDoubleListener);
            |}"""

        assertEquals(expectedRangeDoubleParamChangeListenerMethodSpecString.trimMargin(), rangeDoubleParamChangeListenerMethodSpec.toString().trimMargin())
    }


    @Test
    fun generateShowCockpitMethodTest() {
        val funSpec = cockpitGenerator.generateShowCockpitMethod()

        val expectedFunSpecString = """
            |public static void showCockpit(androidx.fragment.app.FragmentManager fragmentManager) {
            |  if (fragmentManager.findFragmentByTag("Cockpit") == null) {
            |    com.polidea.cockpit.paramsedition.CockpitDialog cockpitDialog = com.polidea.cockpit.paramsedition.CockpitDialog.Companion.newInstance();
            |    cockpitDialog.show(fragmentManager, "Cockpit");
            |  }
            |}"""

        assertEquals(expectedFunSpecString.trimMargin(), funSpec.toString().trimMargin())
    }

    @Test
    fun createColorListenerMapFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createColorListenerMapFieldSpec()

        val expectedFieldSpecString = """
            |private static final java.util.Map<com.polidea.cockpit.event.PropertyChangeListener<java.lang.String>, com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitColor>> colorListenerMap = new java.util.HashMap<>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createRangeIntListenerMapFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createRangeListenerMapFieldSpec(Int::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final java.util.Map<com.polidea.cockpit.event.PropertyChangeListener<java.lang.Integer>, com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Integer>>> rangeIntegerListenerMap = new java.util.HashMap<>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createRangeDoubleListenerMapFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createRangeListenerMapFieldSpec(Double::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final java.util.Map<com.polidea.cockpit.event.PropertyChangeListener<java.lang.Double>, com.polidea.cockpit.event.PropertyChangeListener<com.polidea.cockpit.core.type.CockpitRange<java.lang.Double>>> rangeDoubleListenerMap = new java.util.HashMap<>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitColorMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createColorMapperFieldSpec()

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitColorMapper cockpitColorMapper = new com.polidea.cockpit.mapper.CockpitColorMapper();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitStepIntMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createStepMapperFieldSpec(Int::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitStepMapper<java.lang.Integer> cockpitStepIntegerMapper = new com.polidea.cockpit.mapper.CockpitStepMapper<java.lang.Integer>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitStepDoubleMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createStepMapperFieldSpec(Double::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitStepMapper<java.lang.Double> cockpitStepDoubleMapper = new com.polidea.cockpit.mapper.CockpitStepMapper<java.lang.Double>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitRangeIntMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createRangeMapperFieldSpec(Int::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitRangeMapper<java.lang.Integer> cockpitRangeIntegerMapper = new com.polidea.cockpit.mapper.CockpitRangeMapper<java.lang.Integer>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitRangeDoubleMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createRangeMapperFieldSpec(Double::class.javaObjectType)

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitRangeMapper<java.lang.Double> cockpitRangeDoubleMapper = new com.polidea.cockpit.mapper.CockpitRangeMapper<java.lang.Double>();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createCockpitReadOnlyMapperFieldSpecTest() {
        val fieldSpec = cockpitGenerator.createReadOnlyMapperFieldSpec()

        val expectedFieldSpecString = """
            |private static final com.polidea.cockpit.mapper.CockpitReadOnlyMapper cockpitReadOnlyMapper = new com.polidea.cockpit.mapper.CockpitReadOnlyMapper();
            """
        assertEquals(expectedFieldSpecString.trimMargin(), fieldSpec.toString().trimMargin())
    }

    @Test
    fun createSelectedValueGetterMethodSpecForParamTest() {
        val arrayList = listOf("a", "b", "c")
        val funSpec = cockpitGenerator.createSelectedValueGetterMethodSpecForParam(CockpitParam("name", CockpitListType(arrayList, 1)))

        val expectedFunSpecString = """
            |public static java.lang.String getNameSelectedValue() {
            |  return com.polidea.cockpit.manager.CockpitManager.INSTANCE.getSelectedValue("name");
            |}"""

        assertEquals(expectedFunSpecString.trimMargin(), funSpec.toString().trimMargin())
    }
}