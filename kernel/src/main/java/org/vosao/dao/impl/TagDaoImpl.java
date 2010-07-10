/**
 * Vosao CMS. Simple CMS for Google App Engine.
 * Copyright (C) 2009 Vosao development team
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * email: vosao.dev@gmail.com
 */

package org.vosao.dao.impl;

import java.util.List;

import org.mapsto.Filter;
import org.mapsto.Query;
import org.vosao.dao.BaseDaoImpl;
import org.vosao.dao.BaseMapstoDaoImpl;
import org.vosao.dao.TagDao;
import org.vosao.entity.TagEntity;

public class TagDaoImpl extends BaseMapstoDaoImpl<TagEntity> 
		implements TagDao {

	public TagDaoImpl() {
		super("TagEntity");
	}

	@Override
	public TagEntity getByName(final Long parent, final String name) {
		Query<TagEntity> q = newQuery();
		q.addFilter("parent", Filter.EQUAL, parent);
		q.addFilter("name", Filter.EQUAL, name);
		return q.selectOne("getByName", params(parent, name));
	}

	@Override
	public List<TagEntity> selectByParent(final Long parent) {
		Query<TagEntity> q = newQuery();
		q.addFilter("parent", Filter.EQUAL, parent);
		return q.select("selectByParent", params(parent));
	}

}
