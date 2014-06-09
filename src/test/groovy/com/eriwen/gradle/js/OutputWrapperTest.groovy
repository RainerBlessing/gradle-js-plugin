package com.eriwen.gradle.js

import org.junit.Test

import static junit.framework.Assert.assertEquals


class OutputWrapperTest {
    @Test
    void emptyWrapper(){
        def compilerOutput = 'output'
        def outputWrapper= OutputWrapper.OUTPUT_PLACEHOLDER+'\n//@ sourceMappingURL=all.sourcemap.json'

        def wrapped = OutputWrapper.wrapOutput(compilerOutput, outputWrapper)

        assertEquals('output\n//@ sourceMappingURL=all.sourcemap.json\n',wrapped[1])
        assertEquals('',wrapped[0])
    }
}
