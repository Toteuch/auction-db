package com.toteuch.auctiondb.json;

public abstract class ResponseBlizzard {
	private Links _links;
	
	public class Links {
		private Self self;

		public class Self {
			private String href;

			public String getHref() {
				return href;
			}

			public void setHref(String href) {
				this.href = href;
			}
		}
		
		public Self getSelf() {
			return self;
		}

		public void setSelf(Self self) {
			this.self = self;
		}
		
	}

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}
	
}
