/* SPDX-License-Identifier: MIT */

package li.cil.oc2r.common.vm.context;

import java.util.BitSet;

public interface InterruptManager {
    int getInterruptCount();

    void releaseInterrupts(BitSet interrupts);
}
