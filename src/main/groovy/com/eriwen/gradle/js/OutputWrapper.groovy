package com.eriwen.gradle.js

class OutputWrapper {
    final static OUTPUT_PLACEHOLDER='%output%'

    //code from closure-compiler
    def static wrapOutput(String compilerOutput, String outputWrapper) {
//        Appendable out, Compiler compiler, String code,
//                                                  String wrapper, String codePlaceholder,
//        @Nullable Function<String, String> escaper
        def out = ''
        def prefix = ''

        def pos = outputWrapper.indexOf(OUTPUT_PLACEHOLDER)

        if (pos != -1) {

            if (pos > 0) {
                prefix = outputWrapper.substring(0, pos)
                out.append(prefix)
            }

            //out.append(escaper == null ? code : escaper.apply(code));
            out += compilerOutput

            def suffixStart = pos + OUTPUT_PLACEHOLDER.length()
            if (suffixStart != outputWrapper.length()) {
                // Something after placeholder?
                out += outputWrapper.substring(suffixStart)
            }
            // Make sure we always end output with a line feed.
            out += '\n'

        } else {
            out = compilerOutput
            out += '\n'
        }

        [prefix, out]
    }
}
