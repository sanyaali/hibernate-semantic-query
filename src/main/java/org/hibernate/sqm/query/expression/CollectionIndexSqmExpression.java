/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or visit http://www.apache.org/licenses/LICENSE-2.0
 */
package org.hibernate.sqm.query.expression;


import org.hibernate.sqm.SemanticQueryWalker;
import org.hibernate.sqm.domain.Type;
import org.hibernate.sqm.query.from.FromElement;

/**
 * @author Steve Ebersole
 */
public class CollectionIndexSqmExpression implements SqmExpression {
	private final String collectionAlias;
	private final Type indexType;

	public CollectionIndexSqmExpression(FromElement collectionReference, Type indexType) {
		this.collectionAlias = collectionReference.getIdentificationVariable();
		this.indexType = indexType;
	}

	public String getCollectionAlias() {
		return collectionAlias;
	}

	public Type getIndexType() {
		return indexType;
	}

	@Override
	public Type getExpressionType() {
		return getIndexType();
	}

	@Override
	public Type getInferableType() {
		return getIndexType();
	}

	@Override
	public <T> T accept(SemanticQueryWalker<T> walker) {
		return walker.visitCollectionIndexFunction( this );
	}
}
