<%@ include file="/init.jsp" %>
<div class="container-fluid-1280">
	<div class="flex-container">

		<liferay-ui:search-container emptyResultsMessage="There are no integration infos for this class.">
			<liferay-ui:search-container-results results="${Assignments}" />
			<liferay-ui:search-container-row
				className="com.sohlman.liferay.perm.integ.model.IntegrationInfo"
				modelVar="integrationInfo" escapedModel="true">


				<liferay-frontend:icon-vertical-card icon="cards2"
					title="${assignment.getTitle(locale)}"
					actionJsp="/card_actions.jsp"
					cssClass="col-md-3 flex-item-break-xs card-row-padded"
					actionJspServletContext="${application}" resultRow="${row}">

					<liferay-frontend:vertical-card-footer>
						<p class="truncate-text flex-item-center">${integrationInfo.getClassName()}</p>
					</liferay-frontend:vertical-card-footer>
				</liferay-frontend:icon-vertical-card>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>