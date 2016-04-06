
% 2015-10-17 01:05:37

% my_logs\longTest1\0_0_2\rep_0\priority_log.m
scheduling_duration_us = 3182;

% schedule
schedule_f_t_n(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 5, 0, 0, 0; 3, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 0, 0, 0];
vioTp = [1700];
vioLcy = [4240];
vioJit = [3065];
cost_vio = 72040;
cost_switches = 400;
cost_ch = 829;
costTotal = 73269;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|5	|5	|5	|5	|5	|5	|5	|	|[10]	|	|	|	|	|	|5	|3	|	|	|[20]	|	|	|	|	|
% ############### Network 1 ##############
% ############### Network 2 ##############
% ############### Network 3 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|5	|[10]5	|5	|5	|5	|5	|5	|	|	|	|	|[20]	|	|	|	|	|
