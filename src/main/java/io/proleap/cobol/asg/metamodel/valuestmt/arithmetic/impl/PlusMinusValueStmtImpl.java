/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.valuestmt.arithmetic.impl;

import io.proleap.cobol.Cobol85Parser.MultDivContext;
import io.proleap.cobol.Cobol85Parser.MultDivsContext;
import io.proleap.cobol.Cobol85Parser.PlusMinusContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.valuestmt.arithmetic.MultDivsValueStmt;
import io.proleap.cobol.asg.metamodel.valuestmt.arithmetic.PlusMinusValueStmt;
import io.proleap.cobol.asg.metamodel.valuestmt.impl.ValueStmtImpl;

public class PlusMinusValueStmtImpl extends ValueStmtImpl implements PlusMinusValueStmt {

	protected PlusMinusContext ctx;

	protected MultDivsValueStmt multDivs;

	protected Type type;

	public PlusMinusValueStmtImpl(final ProgramUnit programUnit, final PlusMinusContext ctx) {
		super(programUnit, ctx);
	}

	@Override
	public MultDivsValueStmt addMultDivs(final MultDivsContext ctx) {
		MultDivsValueStmt result = (MultDivsValueStmt) getASGElement(ctx);

		if (result == null) {
			result = new MultDivsValueStmtImpl(programUnit, ctx);

			// powers
			result.addPowers(ctx.powers());

			// mult div
			for (final MultDivContext multDivContext : ctx.multDiv()) {
				result.addMultDiv(multDivContext);
			}

			subValueStmts.add(result);
		}

		return result;
	}

	@Override
	public MultDivsValueStmt getMultDivs() {
		return multDivs;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setType(final Type type) {
		this.type = type;
	}

}
