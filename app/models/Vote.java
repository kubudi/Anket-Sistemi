package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Vote extends Model {

		public String category;
		public String location;

	
	public Vote(String category, String location) {
		super();
		this.category=category;
		this.location=location;
		}
	
	
}
