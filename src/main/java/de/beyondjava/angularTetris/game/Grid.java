/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.beyondjava.angularTetris.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import de.beyondjava.angularTetris.settings.SettingsBean;

@ManagedBean
@RequestScoped
public class Grid implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{settingsBean}")
	private SettingsBean settings;

	public List<Row> rows;

	public List<Row> getRows() {
		return rows;
	}

	public Grid() {
	}

	@PostConstruct
	public void init() {
		rows = new ArrayList<Row>();
		for (int y = 0; y < settings.getNumberOfRows(); y++) {
			rows.add(new Row(settings.getNumberOfColumns()));
		}
	}

	public void setSettings(SettingsBean settings) {
		this.settings = settings;
	}

}
